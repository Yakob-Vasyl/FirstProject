package audioshop.service;

import audioshop.dto.filter.SpeakersFilter;
import audioshop.dto.form.SpeakersForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Speakers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface SpeakersService {
    void save(SpeakersForm speakers);
    List<Speakers> findAll();
    Speakers findOne(int id);
    void delete(int id);

    List<Speakers> findSpeakersWithCategory(int category);

    List<Brands> getBrandsFromSpeakers(int category);
    SpeakersForm findForm(int id);
    Speakers findUnique(String product_name, Brands brand, Connection connection, Category category, int impedance, int sensitivity, int power, String color );
    Page<Speakers> findAll(Pageable pageable);
    Page<Speakers> findAll(Pageable pageable, SpeakersFilter filter);

}
