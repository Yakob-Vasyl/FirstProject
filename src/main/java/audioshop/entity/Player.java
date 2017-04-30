package audioshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vasya on 022 22 01 2017.
 */

@Entity
@Table(name="player")

public class Player extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brands brand;

    private int sample_rate;

    private int signal_noise;
    private int power;
    private int weight;
    @Column(name = "price")
    private int price;
    private String bandwidth;
    private int version;


    @ManyToMany
    @JoinTable(name = "player_format",
            joinColumns = @JoinColumn(name = "id_player"),
            inverseJoinColumns = @JoinColumn(name = "id_format"))
    private List<Format> formats;

    @ManyToMany
    @JoinTable(name = "player_connection",
            joinColumns = @JoinColumn(name = "id_player"),
            inverseJoinColumns = @JoinColumn(name = "id_connection"))
    private List<Connection> connections;
/*

    @ManyToMany(mappedBy = "players")
    private List<ShopingCart> shopingCarts = new ArrayList<>();
*/

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public int getSample_rate() {
        return sample_rate;
    }

    public void setSample_rate(int sample_rate) {
        this.sample_rate = sample_rate;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getSignal_noise() {
        return signal_noise;
    }

    public void setSignal_noise(int signal_noise) {
        this.signal_noise = signal_noise;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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


    public Player() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return id == player.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
