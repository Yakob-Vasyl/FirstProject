package audioshop.specification;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Connection;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by vasya on 006 06 03 2017.
 */
public class ConnectionSpecification implements Specification<Connection> {


    private final SimpleFilter simpleFilter;

    public ConnectionSpecification(SimpleFilter simpleFilter) {
        this.simpleFilter = simpleFilter;
    }

    @Override
    public Predicate toPredicate(Root<Connection> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if(simpleFilter.getSearch().isEmpty())return null;
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("connection")), simpleFilter.getSearch().toLowerCase() + "%");
    }
}
