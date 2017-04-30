package audioshop.service;

import audioshop.entity.User;

/**
 * Created by vasya on 013 13 03 2017.
 */
public interface UserService {
    void save(User user);
    User findUnique(String email, String password);

    User findByEmail(String email);
}
