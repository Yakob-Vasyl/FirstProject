package audioshop.dto.filter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasya on 010 10 03 2017.
 */
public class PlayerFilter {

    private String search="";
    private String maxPrice ="";
    private String minPrice ="";
    private String signalNoise = "";
    private String sampleRate = "";
    private Integer signalNoiseValue;
    private Integer sampleRateValue;
    private Integer maxValue;
    private Integer minValue;

    private String categoryId;
    private Integer categoryIdValue;

    private List<Integer> brandId = new ArrayList<>();

    private List<Integer> connectionId = new ArrayList<>();

    private List<Integer> formatId = new ArrayList<>();

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

    public List<Integer> getFormatId() {
        return formatId;
    }

    public void setFormatId(List<Integer> formatId) {
        this.formatId = formatId;
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

    public String getSignalNoise() {
        return signalNoise;
    }

    public void setSignalNoise(String signalNoise) {
        this.signalNoise = signalNoise;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public Integer getSignalNoiseValue() {
        return signalNoiseValue;
    }

    public void setSignalNoiseValue(Integer signalNoiseValue) {
        this.signalNoiseValue = signalNoiseValue;
    }

    public Integer getSampleRateValue() {
        return sampleRateValue;
    }

    public void setSampleRateValue(Integer sampleRateValue) {
        this.sampleRateValue = sampleRateValue;
    }
}
