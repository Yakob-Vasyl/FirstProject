package audioshop.dto.filter;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by vasya on 019 19 03 2017.
 */
public class CategoryFilter {
    private String categoryId;
    private Integer categoryIdValue;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryIdValue() {
        return categoryIdValue;
    }

    public void setCategoryIdValue(Integer categoryIdValue) {
        this.categoryIdValue = categoryIdValue;
    }
}
