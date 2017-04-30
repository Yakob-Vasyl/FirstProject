package audioshop.dto.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasya on 010 10 03 2017.
 */
public class SpeakersFilter {

    private String search="";
    private String maxPrice ="";
    private String minPrice ="";
    private Integer maxValue;
    private Integer minValue;

    private String categoryId;
    private Integer categoryIdValue;
    private List<Integer> brandId = new ArrayList<>();

    private List<Integer> connectionId = new ArrayList<>();

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public List<Integer> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<Integer> brandId) {
        this.brandId = brandId;
    }

    public List<Integer> getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(List<Integer> connectionId) {
        this.connectionId = connectionId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

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
