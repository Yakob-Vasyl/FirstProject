package audioshop.serviceImpl;

import audioshop.Dao.ShopingCartDao;
import audioshop.entity.ShopingCart;
import audioshop.service.ShopingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vasya on 004 04 05 2017.
 */
@Service
public class ShopingCartServiceImp implements ShopingCartService {

    @Autowired
    private ShopingCartDao shopingCartDao;

    @Override
    public void save(ShopingCart cart) {
        shopingCartDao.save(cart);
    }

    @Override
    public List<ShopingCart> findAll() {
        return shopingCartDao.findAll();
    }

    @Override
    public ShopingCart findOne(int id) {
        return shopingCartDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        shopingCartDao.delete(id);
    }
}
