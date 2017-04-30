package audioshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vasya on 003 03 04 2017.
 */
@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "product")
    private List<ShopingCart> shopingCarts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<ShopingCart> getShopingCarts() {
        return shopingCarts;
    }

    public void setShopingCarts(List<ShopingCart> shopingCarts) {
        this.shopingCarts = shopingCarts;
    }
}
