package audioshop.serviceImpl;

import audioshop.Dao.UserDao;
import audioshop.entity.Role;
import audioshop.entity.User;
import audioshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by vasya on 013 13 03 2017.
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService , UserDetailsService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public User findUnique(String email, String password) {
        return userDao.findUnique(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void save(User user) {
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return userDao.findByEmail(s);
    }

    @PostConstruct
    public void addAdmin(){
        User user = userDao.findByEmail("admin");
        if(user==null){
            user = new User();
            user.setEmail("admin");
            user.setPassword(encoder.encode("admin"));
            user.setRole(Role.ROLE_ADMIN);
            userDao.save(user);
        }
    }
}
