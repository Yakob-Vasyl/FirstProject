package audioshop.Dao;

import audioshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by vasya on 013 13 03 2017.
 */
public interface UserDao extends JpaRepository<User,Integer> {

    @Query("select distinct u from User u left join fetch u.shopingCarts where u.email=?1 and u.password=?2")
    User findUnique(String email, String password);

    @Query("select distinct u from User u left join fetch u.shopingCarts where u.email=?1")
    User findByEmail(String s);

}
