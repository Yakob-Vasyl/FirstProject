package audioshop.specification;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Format;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by vasya on 006 06 03 2017.
 */
public class FormatSpecification implements Specification<Format> {
    private final SimpleFilter simpleFilter;

    public FormatSpecification(SimpleFilter simpleFilter) {
        this.simpleFilter = simpleFilter;
    }

    @Override
    public Predicate toPredicate(Root<Format> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if(simpleFilter.getSearch().isEmpty())return null;
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("format")), simpleFilter.getSearch().toLowerCase() + "%");
    }
}
