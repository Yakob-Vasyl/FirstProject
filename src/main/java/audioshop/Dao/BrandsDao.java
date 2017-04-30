package audioshop.Dao;

import audioshop.entity.Brands;
import audioshop.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface BrandsDao extends JpaRepository<Brands,Integer>,JpaSpecificationExecutor<Brands> {
    @Query("select distinct b from Brands b left join fetch b.players where b.id=:id")
    Brands fetchBrandWithPlayers(@Param("id") int id);
    @Query("SELECT b from Brands b where b.brand=?1")
    Brands findByBrand(String brand);
}
