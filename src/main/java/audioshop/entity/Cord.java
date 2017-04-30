package audioshop.entity;

import javax.persistence.*;

/**
 * Created by vasya on 023 23 01 2017.
 */
@Entity
@Table(name="cord")
public class Cord extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private  int id;
    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brands brand;

    @ManyToOne
    private Connection connection;
    private int length;
    private String material;
    private int version;
    @Column(name = "price")
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product_name) {
        this.productName = product_name;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Cord() {
    }
}