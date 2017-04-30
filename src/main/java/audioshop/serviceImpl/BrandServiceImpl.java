package audioshop.serviceImpl;

import audioshop.Dao.BrandsDao;
import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Brands;
import audioshop.service.BrandsService;
import audioshop.specification.BrandSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vasya on 001 01 02 2017.
 */
@Service
public class BrandServiceImpl implements BrandsService {


    @Autowired
    private BrandsDao brandsDao;

    public void save(Brands brands) {
        brandsDao.save(brands);
    }

    public List<Brands> findAll() {
        return brandsDao.findAll();
    }

    public Brands findOne(int id) {
        return brandsDao.findOne(id);
    }

    public void delete(int id) {
        brandsDao.delete(id);
    }

    @Override
    public Brands fetchBrandWithPlayers(int id) {
        return brandsDao.fetchBrandWithPlayers(id);
    }

    @Override
    public Brands findByBrand(String brand) {
        return brandsDao.findByBrand(brand);
    }

    @Override
    public Page<Brands> findAll(Pageable pageable, SimpleFilter filter) {
        return brandsDao.findAll(new BrandSpecification(filter),pageable);
    }
}
