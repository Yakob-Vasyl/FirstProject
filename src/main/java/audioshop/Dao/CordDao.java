package audioshop.Dao;

import audioshop.entity.Brands;
import audioshop.entity.Cord;
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

public interface CordDao extends JpaRepository<Cord, Integer>, JpaSpecificationExecutor<Cord> {


    @Query("select c from Cord c WHERE c.productName=?1 and c.brand.id=?2 and c.connection.id=?3 and c.length=?4 and c.price =?5 and c.category.id=?6 ")
    Cord findUnique(String product_name, int brandId, int connectionId, int length, int price, int category);

    @Query("select c from Cord c where c.category.id=?1")
    List<Cord> findCordsWithCategory(int category);

    @Query(value = "SELECT c FROM Cord c LEFT JOIN FETCH c.brand LEFT JOIN FETCH c.connection",
            countQuery = "SELECT count(c.id) FROM Cord c")
    Page<Cord> findAll(Pageable pageable);

}
