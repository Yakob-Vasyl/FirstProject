package audioshop.service;

import audioshop.dto.filter.CordFilter;
import audioshop.dto.form.CordForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Cord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface CordService {
    void save(CordForm form);
    List<Cord> findAll();
    Cord findOne(int id);
    void delete(int id);

    Cord findUnique(String product_name, Brands brand, Connection connection, int length, int price , Category category);

    CordForm findForm(int id);
    List<Cord> findCordsWithCategory(int category);

    List<Brands> getBrandsFromCord(int category);
    Page<Cord> findAll(Pageable pageable);

    Page<Cord> findAll(Pageable pageable, CordFilter filter);
}
