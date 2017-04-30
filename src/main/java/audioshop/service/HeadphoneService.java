package audioshop.service;

import audioshop.dto.filter.HeadphoneFilter;
import audioshop.dto.form.HeadphoneForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Headphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface HeadphoneService {
    void save(HeadphoneForm headphone);
    List<Headphone> findAll();
    Headphone findOne(int id);
    void delete(int id);

    List<Headphone> findHeadphonesWithCategory(int category);

    List<Brands> getBrandsFromHeadphones(int category);

    HeadphoneForm findForm(int id);
    Headphone findUnique(String product_name, Brands brand, Connection connection , int resistance, int cordLength , int sensitivity, Category category, int price);
    Page<Headphone> findAll(Pageable pageable);
    Page<Headphone> findAll(Pageable pageable, HeadphoneFilter filter);

}
