package audioshop.service;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Connection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface ConnectionService {
    void save(Connection connection);
    List<Connection> findAll();
    Connection findOne(int id);
    void delete(int id);
    Connection findByConnection(String connection);
    Page<Connection> findAll(Pageable pageable, SimpleFilter filter);

}
