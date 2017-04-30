package audioshop.Dao;

import audioshop.entity.Speakers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vasya on 025 25 01 2017.
 */

public interface SpeakersDao extends JpaRepository<Speakers, Integer>  ,JpaSpecificationExecutor<Speakers> {

    @Query("select s from Speakers s where s.productName=?1 and s.brand.id=?2 and s.connection.id=?3 and s.category.id=?4 and s.impedance=?5 and s.sensitivity=?6 and s.power=?7 and s.color=?8")
    Speakers findUnique(String product_name, int brandId, int connectionId ,int category, int impedance,int sensitivity, int power,String color);
    @Query("select s from Speakers s where s.category.id=?1")
    List<Speakers> findSpeakersWithCategory(int category);

    @Query(value="SELECT s FROM Speakers s LEFT JOIN FETCH s.brand LEFT JOIN FETCH s.connection",
            countQuery="SELECT count(s.id) FROM Speakers s")
    Page<Speakers> findAll(Pageable pageable);

}
