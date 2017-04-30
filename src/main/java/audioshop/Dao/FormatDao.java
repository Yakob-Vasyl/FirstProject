package audioshop.Dao;

import audioshop.entity.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface FormatDao extends JpaRepository<Format,Integer> ,JpaSpecificationExecutor<Format> {
    @Query("select distinct f from Format f left join fetch f.players where f.id=:id")
    Format fetchFormatWithPlayers(@Param("id") int id);
    @Query("select f from Format f where f.format=?1")
    Format findByFormat(String format);
}
