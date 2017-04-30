package audioshop.Dao;

import audioshop.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by vasya on 030 30 01 2017.
 */
public interface ConnectionDao extends JpaRepository<Connection,Integer> ,JpaSpecificationExecutor<Connection> {
    @Query("select c from Connection c where c.connection=?1")
    Connection findByConnection(String connection);
}
