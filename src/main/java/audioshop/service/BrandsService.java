package audioshop.service;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Brands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface BrandsService {
    void save(Brands brands);
    List<Brands> findAll();
    Brands findOne(int id);
    void delete(int id);
    Brands fetchBrandWithPlayers( int id);

    Brands findByBrand(String brand);
    Page<Brands> findAll(Pageable pageable, SimpleFilter filter);
}
