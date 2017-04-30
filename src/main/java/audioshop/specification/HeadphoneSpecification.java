package audioshop.specification;

import audioshop.dto.filter.HeadphoneFilter;
import audioshop.entity.Headphone;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by vasya on 010 10 03 2017.
 */
public class HeadphoneSpecification implements Specification<Headphone> {

    private final HeadphoneFilter filter;

    private final static Pattern PATTERN= Pattern.compile("(\\d+)");

    private final List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<Headphone> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        fetch(root, query);
        // filterBySearch(root, criteriaQuery, cb);
        filterByPrice(root, query, cb);
         filterByBrand(root, query, cb);
        filterByConnection(root, query, cb);
        filterByCategory(root, query, cb);
        if (predicates.isEmpty()) return null;
        Predicate[] array = new Predicate[predicates.size()];
        array = predicates.toArray(array);
        return cb.and(array);
    }


    public HeadphoneSpecification(HeadphoneFilter filter) {
        this.filter = filter;
        if (PATTERN.matcher(filter.getMaxPrice()).matches()) {
            filter.setMaxValue(new Integer(filter.getMaxPrice()));
        }
        if (PATTERN.matcher(filter.getMinPrice()).matches()) {
            filter.setMinValue(new Integer(filter.getMinPrice()));
        }
    }
    private void filterByCategory(Root<Headphone> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(filter.getCategoryIdValue()!=null){
            predicates.add(cb.equal(root.get("category"), filter.getCategoryIdValue()));
        }
    }
    private void filterByPrice(Root<Headphone> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(filter.getMaxValue()!=null){
            predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
        }
        if(filter.getMinValue()!=null){
            predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
        }

    }
    private void filterByBrand(Root<Headphone> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (!filter.getBrandId().isEmpty()) {
            predicates.add(root.get("brand").in(filter.getBrandId()));
        }
    }
    private void filterByConnection(Root<Headphone> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (!filter.getConnectionId().isEmpty()) {
            predicates.add(root.get("connection").in(filter.getConnectionId()));
        }
    }
    private void fetch(Root<Headphone> root, CriteriaQuery<?> criteriaQuery) {
        if (!criteriaQuery.getResultType().equals(Long.class)) {
            criteriaQuery.distinct(true);
            root.fetch("brand", JoinType.LEFT);
            root.fetch("category", JoinType.LEFT);
            root.fetch("connection",JoinType.LEFT);
        }
    }
}
