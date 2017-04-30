package audioshop.validator;

import audioshop.entity.Connection;
import audioshop.service.ConnectionService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vasya on 028 28 02 2017.
 */
public class ConnectionValidator implements Validator {
    private final ConnectionService connectionService;

    public ConnectionValidator(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Connection.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Connection connection = (Connection) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "connection", "", "Can`t be empty");
        if (connectionService.findByConnection(connection.getConnection()) != null) {
            errors.rejectValue("connection","","Already exist");
        }
    }
}
