package audioshop.service;

import audioshop.Dao.PlayerDao;
import audioshop.dto.filter.PlayerFilter;
import audioshop.dto.form.PlayerForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Format;
import audioshop.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vasya on 027 27 01 2017.
 */

public interface PlayerService {
    void save(PlayerForm form);
    List<Player> findAll();
    Player findOne(int id);
    void delete(int id);
    PlayerForm findForm(int id);
    Player fetchPlayerWithFormats(int id);
    Player fetchPlayerWithInterfaces(int id);

    Player findUnique(String product_name, Brands brands, Category category, int sample_rate , int signal_noise, int power, String bandwidth);
    List<Player> findPlayersWithCategory(int category);

    List<Brands> getBrandsFromPlayer(int category);

    Page<Player> findAll(Pageable pageable);
    Page<Player> findAll(Pageable pageable, PlayerFilter filter);


}
