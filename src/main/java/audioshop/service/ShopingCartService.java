package audioshop.service;

import audioshop.entity.ShopingCart;

import java.util.List;

/**
 * Created by vasya on 004 04 05 2017.
 */
public interface ShopingCartService {
    void save(ShopingCart cart);
    List<ShopingCart> findAll();
    ShopingCart findOne(int id);
    void delete(int id);
}
