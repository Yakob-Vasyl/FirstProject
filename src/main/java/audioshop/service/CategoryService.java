package audioshop.service;

import audioshop.entity.Category;

import java.util.List;

/**
 * Created by vasya on 015 15 03 2017.
 */
public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
    Category findOne(int id);
    void delete(int id);


}
