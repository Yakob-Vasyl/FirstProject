package audioshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasya on 029 29 03 2017.
 */
@Entity
public class ShopingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Product product ;

    @ManyToOne
    private User user ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
