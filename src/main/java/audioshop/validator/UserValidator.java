package audioshop.validator;

import audioshop.entity.User;
import audioshop.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vasya on 013 13 03 2017.
 */
public class UserValidator implements Validator {

    private final UserService service;

    public UserValidator(UserService service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can`t be empty");

        if (service.findUnique(user.getEmail(),user.getPassword()) != null) {
            errors.rejectValue("email","","Already exist");
        }

    }
}
