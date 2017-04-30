package audioshop.serviceImpl;

import audioshop.Dao.PlayerDao;
import audioshop.dto.filter.PlayerFilter;
import audioshop.dto.form.PlayerForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Player;
import audioshop.service.FileWriter;
import audioshop.service.PlayerService;
import audioshop.specification.PlayerSpecification;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vasya on 030 30 01 2017.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private FileWriter fileWriter;

    @Autowired
    private PlayerDao playerDao;
    @Override
    @Transactional
    public Page<Player> findAll(Pageable pageable) {
        Page<Player> players = playerDao.findAll(pageable);
        players.forEach(player -> Hibernate.initialize(player.getFormats()));
        return players;
    }

    @Override
    @Transactional
    public Page<Player> findAll(Pageable pageable, PlayerFilter filter) {
        Page<Player> players = playerDao.findAll(new PlayerSpecification(filter), pageable);
        players.forEach(player -> Hibernate.initialize(player.getFormats()));
        return players;
    }


    @Override
    public List<Brands> getBrandsFromPlayer(int category) {
        return findPlayersWithCategory(category).stream().map(Player::getBrand).collect(Collectors.toList());
    }

    /* @Autowired
        private EntityManagerFactory factory;

        private EntityManager entityManager = factory.createEntityManager();*/
    @Transactional

    public PlayerForm findForm(int id) {
        PlayerForm form = new PlayerForm();
        Player entity = findOne(id);
        form.setId(entity.getId());
        form.setProductName(entity.getProductName());
        form.setBrand(entity.getBrand());
        form.setConnections(entity.getConnections());
        form.setFormats(entity.getFormats());

        form.setCategory(entity.getCategory());
        form.setSample_rate(String.valueOf(entity.getSample_rate()));
        form.setBandwidth(entity.getBandwidth());
        form.setSignal_noise(String.valueOf(entity.getSignal_noise()));
        form.setPower(String .valueOf(entity.getPower()));
        form.setWeight(String.valueOf(entity.getWeight()));
        form.setPrice(String.valueOf(entity.getPrice()));
        form.setVersion(entity.getVersion());
        return form;
        
    }


    @Override
    public Player findUnique(String product_name, Brands brands, Category category, int sample_rate, int signal_noise, int power, String bandwidth) {
        return playerDao.findUnique(product_name, brands.getId(),category.getId(), sample_rate, signal_noise, power, bandwidth);
    }

    public List<Player> findPlayersWithCategory(int category) {
        return playerDao.findPlayersWithCategory(category);
    }

    @Transactional
    public void save(PlayerForm form) {
        Player entity = new Player();
        entity.setId(form.getId());
        entity.setBrand(form.getBrand());
        entity.setProductName(form.getProductName());
        entity.setConnections(form.getConnections());
        entity.setFormats(form.getFormats());

        entity.setCategory(form.getCategory());
        entity.setSample_rate(Integer.valueOf(form.getSample_rate()));
        entity.setBandwidth(form.getBandwidth());
        entity.setSignal_noise(Integer.valueOf(form.getSignal_noise()));
        entity.setPower(Integer.valueOf(form.getPower()));
        entity.setWeight(Integer.valueOf(form.getWeight()));
        entity.setPrice(Integer.valueOf(form.getPrice()));

        MultipartFile file = form.getFile();
        playerDao.saveAndFlush(entity);
        if(fileWriter.write(FileWriter.Folder.PLAYER, file, entity.getId())){
          entity.setVersion(entity.getVersion()+1);
          playerDao.save(entity);
        }
    }

    public List<Player> findAll() {
        return playerDao.findAll();
    }


    @Transactional
    public Player findOne(int id) {
        Player entity = playerDao.fetchPlayerWithInterfaces(id);
        Hibernate.initialize(entity.getFormats());
        return entity;
    }

    /*List<Item> items = em.createQuery("SELECT i FROM Item i WHERE i.name LIKE :name AND i.price > :price", Item.class)
		//цих методів може бути стільки стільки підставних параметрів в запиті
				.setParameter("name", "Б%")
				.setParameter("price", new BigDecimal("3.20"))
				//формує список з результатів
				.getResultList();*/
/*
    @Transactional
    public List<Player> findCategory(String subcategory) {
       List<Player> players = entityManager.createQuery("SELECT p from Player p WHERE p.subcategory LIKE :name").setParameter("name",subcategory).getResultList();
        return players;
    }*/
    public void delete(int id) {
        playerDao.delete(id);
    }



    @Transactional
    public Player fetchPlayerWithFormats(int id) {
        return playerDao.fetchPlayerWithFormats(id);
    }


    @Transactional
    public Player fetchPlayerWithInterfaces(int id) {
        return playerDao.fetchPlayerWithInterfaces(id);
    }

}
