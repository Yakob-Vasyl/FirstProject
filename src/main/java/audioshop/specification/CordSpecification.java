package audioshop.specification;

import audioshop.dto.filter.CordFilter;
import audioshop.entity.Cord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by vasya on 008 08 03 2017.
 */
public class CordSpecification implements Specification<Cord> {

    private final CordFilter filter;

    private final static Pattern PATTERN= Pattern.compile("(\\d+)");

    private final List<Predicate> predicates = new ArrayList<>();

    public CordSpecification(CordFilter cordFilter) {

        this.filter = cordFilter;
        if (PATTERN.matcher(filter.getMaxPrice()).matches()) {
            filter.setMaxValue(new Integer(filter.getMaxPrice()));
        }
        if (PATTERN.matcher(filter.getMinPrice()).matches()) {
            filter.setMinValue(new Integer(filter.getMinPrice()));
        }
        if (PATTERN.matcher(filter.getCordLength()).matches()) {
            filter.setCordLengthValue(new Integer(filter.getCordLength()));
        }


    }

    private void filterByPrice(Root<Cord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(filter.getMaxValue()!=null){
            predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
        }
        if(filter.getMinValue()!=null){
            predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
        }

    }

    private void filterByLength(Root<Cord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (filter.getCordLengthValue() != null) {
            predicates.add(root.get("length").in(filter.getCordLengthValue()));
        }
    }
    private void filterByCategory(Root<Cord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(filter.getCategoryIdValue()!=null){
            predicates.add(cb.equal(root.get("category"), filter.getCategoryIdValue()));
        }
    }


    private void filterBySearch(Root<Cord> root, CriteriaQuery<?> query, CriteriaBuilder cb){
        if(!filter.getSearch().isEmpty()){
            predicates.add(cb.like(root.get("product_name"), filter.getSearch()+"%"));
        }
    }

    private void filterByBrand(Root<Cord> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (!filter.getBrandId().isEmpty()) {
            predicates.add(root.get("brand").in(filter.getBrandId()));
        }
    }

    private void filterByConnection(Root<Cord> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (!filter.getConnectionId().isEmpty()) {
            predicates.add(root.get("connection").in(filter.getConnectionId()));
        }
    }
    private void fetch(Root<Cord> root, CriteriaQuery<?> criteriaQuery) {
        if (!criteriaQuery.getResultType().equals(Long.class)) {
            criteriaQuery.distinct(true);
            root.fetch("brand",JoinType.LEFT);
            root.fetch("category", JoinType.LEFT);
            root.fetch("connection",JoinType.LEFT);

        }
    }
    @Override

    public Predicate toPredicate(Root<Cord> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        fetch(root, criteriaQuery);
       // filterBySearch(root, criteriaQuery, criteriaBuilder);
        filterByPrice(root, criteriaQuery, criteriaBuilder);
        filterByBrand(root, criteriaQuery, criteriaBuilder);
        filterByConnection(root, criteriaQuery, criteriaBuilder);
        filterByLength(root, criteriaQuery, criteriaBuilder);
        filterByCategory(root, criteriaQuery, criteriaBuilder);
        if (predicates.isEmpty()) return null;
        Predicate[] array = new Predicate[predicates.size()];
        array = predicates.toArray(array);
        return criteriaBuilder.and(array);
    }
}
