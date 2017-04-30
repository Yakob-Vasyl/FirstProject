package audioshop.dto.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasya on 008 08 03 2017.
 */
public class CordFilter {


    private String search="";
    private String maxPrice ="";
    private String minPrice ="";
    private Integer maxValue;
    private Integer minValue;
    private String cordLength="";
    private Integer cordLengthValue;
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

    public String getCordLength() {
        return cordLength;
    }

    public void setCordLength(String cordLength) {
        this.cordLength = cordLength;
    }

    public Integer getCordLengthValue() {
        return cordLengthValue;
    }

    public void setCordLengthValue(Integer cordLengthValue) {
        this.cordLengthValue = cordLengthValue;
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
