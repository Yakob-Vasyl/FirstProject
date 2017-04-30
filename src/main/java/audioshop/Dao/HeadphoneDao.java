package audioshop.Dao;

import audioshop.entity.Brands;
import audioshop.entity.Headphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vasya on 025 25 01 2017.
 */

public interface HeadphoneDao extends JpaRepository<Headphone,Integer>  ,JpaSpecificationExecutor<Headphone> {

    @Query("select h from Headphone h where h.productName=?1 and h.brand.id=?2 and h.connection.id=?3 and h.resistance=?4 and h.cord_length=?5 and h.sensitivity=?6 and h.category.id=?7 and h.price=?8 ")
    Headphone findUnique(String product_name, int brandId, int connectionId, int resistance,int cordLength ,int sensitivity, int categoryId, int price);

    @Query("select h from Headphone h where h.category.id=?1")
    List<Headphone> findHeadphonesWithCategory(int category);

    @Query(value="SELECT h FROM Headphone h LEFT JOIN FETCH h.brand LEFT JOIN FETCH h.connection",
            countQuery="SELECT count(h.id) FROM Headphone h")
    Page<Headphone> findAll(Pageable pageable);

}
