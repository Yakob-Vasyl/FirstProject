package audioshop.serviceImpl;

import audioshop.Dao.CategoryDao;
import audioshop.entity.Category;
import audioshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vasya on 015 15 03 2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findOne(int id) {
        return categoryDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

}
