package audioshop.dto.form;

import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Format;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by vasya on 028 28 02 2017.
 */
public class PlayerForm {


    private int id;
    private String productName;
    private Category category;
    private Brands brand;
    private List<Format> formats;
    private List<Connection> connections;
    private String sample_rate;
    private String bandwidth;
    private String signal_noise;
    private String power;
    private String weight;
    private String price;

    private int version;
    private MultipartFile file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public String getSample_rate() {
        return sample_rate;
    }

    public void setSample_rate(String sample_rate) {
        this.sample_rate = sample_rate;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getSignal_noise() {
        return signal_noise;
    }

    public void setSignal_noise(String signal_noise) {
        this.signal_noise = signal_noise;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
