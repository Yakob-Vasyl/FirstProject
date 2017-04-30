package audioshop.entity;

import javax.persistence.*;

/**
 * Created by vasya on 022 22 01 2017.
 */
@Entity
@Table(name="headphone")
public class Headphone extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brands brand;

    @ManyToOne
    private Connection connection;

    private int resistance;
    private String frequency_range;
    private int sensitivity;
    private boolean have_microphone;
    private int cord_length;
    private String color;
    @Column(name = "price")
    private int price;
    private int version;

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

    public void setConnection(Connection headphone_connection) {
        this.connection = headphone_connection;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public String getFrequency_range() {
        return frequency_range;
    }

    public void setFrequency_range(String frequency_range) {
        this.frequency_range = frequency_range;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public boolean isHave_microphone() {
        return have_microphone;
    }

    public void setHave_microphone(boolean have_microphone) {
        this.have_microphone = have_microphone;
    }

    public int getCord_length() {
        return cord_length;
    }

    public void setCord_length(int cord_length) {
        this.cord_length = cord_length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Headphone() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Headphone headphone = (Headphone) o;

        return id == headphone.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
