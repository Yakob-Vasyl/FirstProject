package audioshop.specification;

import audioshop.dto.filter.PlayerFilter;
import audioshop.entity.Connection;
import audioshop.entity.Cord;
import audioshop.entity.Format;
import audioshop.entity.Player;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by vasya on 010 10 03 2017.
 */
public class PlayerSpecification implements Specification<Player>{

    private final PlayerFilter filter;

    private final static Pattern PATTERN= Pattern.compile("(\\d+)");

    private final List<Predicate> predicates = new ArrayList<>();

    public PlayerSpecification(PlayerFilter filter) {
        this.filter = filter;
        if (PATTERN.matcher(filter.getMaxPrice()).matches()) {
            filter.setMaxValue(new Integer(filter.getMaxPrice()));
        }
        if (PATTERN.matcher(filter.getMinPrice()).matches()) {
            filter.setMinValue(new Integer(filter.getMinPrice()));
        }
        if (PATTERN.matcher(filter.getSampleRate()).matches()) {
            filter.setSampleRateValue(new Integer(filter.getSampleRate()));
        }
        if (PATTERN.matcher(filter.getSignalNoise()).matches()) {
            filter.setSignalNoiseValue(new Integer(filter.getSignalNoise()));
        }

    }

    private void filterByPrice(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(filter.getMaxValue()!=null){
            predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
        }
        if(filter.getMinValue()!=null){
            predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
        }

    }

    private void filterByFormat(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(!filter.getFormatId().isEmpty()){
			Join<Player, Format> join = root.join("formats");
			predicates.add(join.get("id").in(filter.getFormatId()));
		}
    }
    private void filterByConnection(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(!filter.getConnectionId().isEmpty()){
            Join<Player, Connection> join = root.join("connections");
            predicates.add(join.get("id").in(filter.getConnectionId()));
        }
    }
    private void filterByCategory(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(filter.getCategoryIdValue()!=null){
            predicates.add(cb.equal(root.get("category"), filter.getCategoryIdValue()));
        }
    }

    private void filterBySampleRate(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (filter.getSampleRateValue()!= null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("sample_rate"), filter.getSampleRateValue()));
        }
    }
    private void filterBySignalNoise(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (filter.getSignalNoiseValue()!= null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("signal_noise"), filter.getSignalNoiseValue()));
        }
    }
    private void fetch(Root<Player> root, CriteriaQuery<?> criteriaQuery) {
        if (!criteriaQuery.getResultType().equals(Long.class)) {
            criteriaQuery.distinct(true);
            root.fetch("brand", JoinType.LEFT);
            root.fetch("category", JoinType.LEFT);
            root.fetch("connections",JoinType.LEFT);

        }
    }
    private void filterByBrand(Root<Player> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (!filter.getBrandId().isEmpty()) {
            predicates.add(root.get("brand").in(filter.getBrandId()));
        }
    }
    @Override
    public Predicate toPredicate(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        fetch(root, query);
        filterByPrice(root, query, cb);
        filterByFormat(root, query, cb);
        filterByConnection(root, query, cb);
        filterByCategory(root, query, cb);
        filterByBrand(root, query, cb);
        filterBySampleRate(root, query, cb);
        filterBySignalNoise(root, query, cb);
        if (predicates.isEmpty()) return null;
        Predicate[] array = new Predicate[predicates.size()];
        array = predicates.toArray(array);
        return cb.and(array);
    }
}
