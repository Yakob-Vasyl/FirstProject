package audioshop.Dao;

import audioshop.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vasya on 023 23 01 2017.
 */

public interface PlayerDao extends JpaRepository<Player, Integer> , JpaSpecificationExecutor<Player> {

    @Query("select distinct p from Player p left join fetch p.formats where p.id=:id")
    Player fetchPlayerWithFormats(@Param("id") int id);

    @Query("select distinct p from Player p left join fetch p.connections where p.id=?1")
    Player fetchPlayerWithInterfaces(int id);


    @Query("select p from Player p where p.productName=?1 and p.brand.id=?2 and p.category.id=?3 and p.sample_rate=?4 and p.signal_noise=?5 and p.power=?6 and p.bandwidth=?7")
    Player findUnique(String product_name, int brandId, int subcategory, int sample_rate , int signal_noise, int power, String bandwidth);

    @Query("select p from Player p where p.category.id=?1")
    List<Player> findPlayersWithCategory(int category);

    @Query(value="SELECT DISTINCT p FROM Player p LEFT JOIN FETCH p.brand LEFT JOIN FETCH p.connections",
            countQuery="SELECT count(p.id) FROM Player p")
    Page<Player> findAll(Pageable pageable);


}

