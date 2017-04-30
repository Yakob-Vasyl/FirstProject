package audioshop.serviceImpl;

import audioshop.Dao.ConnectionDao;
import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Connection;
import audioshop.service.ConnectionService;
import audioshop.service.FileWriter;
import audioshop.specification.ConnectionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vasya on 001 01 02 2017.
 */
@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Autowired
    private ConnectionDao connectionDao;

    @Autowired
    private FileWriter fileWriter;

    public void save(Connection connection) {
        connectionDao.save(connection);
    }

    public List<Connection> findAll() {
        return connectionDao.findAll();
    }

    public Connection findOne(int id) {
        return connectionDao.findOne(id);
    }

    public void delete(int id) {
        connectionDao.delete(id);
    }

    @Override
    public Connection findByConnection(String connection) {
        return connectionDao.findByConnection(connection);
    }

    @Override
    public Page<Connection> findAll(Pageable pageable, SimpleFilter filter) {
        return connectionDao.findAll(new ConnectionSpecification(filter),pageable);
    }
}
