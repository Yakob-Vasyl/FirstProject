package audioshop.entity;

import javax.persistence.*;

/**
 * Created by vasya on 023 23 01 2017.
 */
@Entity
@Table(name="speakers")
public class Speakers extends Product {
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

    private String frequency_range;
    private int impedance;
    private int sensitivity;
    private int power;
    private String color;
    private int weight;
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

    public void setConnection(Connection speakers_connection) {
        this.connection = speakers_connection;
    }

    public String getFrequency_range() {
        return frequency_range;
    }

    public void setFrequency_range(String frequency_range) {
        this.frequency_range = frequency_range;
    }

    public int getImpedance() {
        return impedance;
    }

    public void setImpedance(int impedance) {
        this.impedance = impedance;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public Speakers() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speakers speakers = (Speakers) o;

        return id == speakers.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
