package audioshop.dto.form;

import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by vasya on 028 28 02 2017.
 */
public class HeadphoneForm {

    private int id;
    private String product_name;
    private Category category;


    private Brands brand;


    private Connection connection;

    private String resistance;
    private String frequency_range;
    private String sensitivity;
    private boolean have_microphone;
    private String cord_length;
    private String color;
    private String price;
    private int version;
    private MultipartFile file;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public String getFrequency_range() {
        return frequency_range;
    }

    public void setFrequency_range(String frequency_range) {
        this.frequency_range = frequency_range;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public boolean isHave_microphone() {
        return have_microphone;
    }

    public void setHave_microphone(boolean have_microphone) {
        this.have_microphone = have_microphone;
    }

    public String getCord_length() {
        return cord_length;
    }

    public void setCord_length(String cord_length) {
        this.cord_length = cord_length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
