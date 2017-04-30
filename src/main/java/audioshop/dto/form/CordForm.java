package audioshop.dto.form;

import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by vasya on 027 27 02 2017.
 */
public class CordForm {

    private int id;

    private String product_name;

    private Brands brand;

    private Connection connection;

    private Category category;

    private String length;

    private String material;

    private int version;

    private MultipartFile file;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;


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
