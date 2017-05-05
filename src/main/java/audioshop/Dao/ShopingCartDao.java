package audioshop.Dao;

import audioshop.entity.ShopingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by vasya on 004 04 05 2017.
 */
public interface ShopingCartDao extends JpaRepository<ShopingCart, Integer>, JpaSpecificationExecutor<ShopingCart> {
}
