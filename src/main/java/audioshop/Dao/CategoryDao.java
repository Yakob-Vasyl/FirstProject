package audioshop.Dao;

import audioshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vasya on 015 15 03 2017.
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {

}
