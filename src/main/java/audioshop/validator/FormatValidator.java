package audioshop.validator;

import audioshop.entity.Format;
import audioshop.service.FormatService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vasya on 028 28 02 2017.
 */
public class FormatValidator implements Validator {

    private final FormatService formatService;

    public FormatValidator(FormatService formatService) {
        this.formatService = formatService;
    }

    @Override

    public boolean supports(Class<?> aClass) {
        return Format.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Format format = (Format) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "format", "", "Can`t be empty");
        if (formatService.findByFormat(format.getFormat()) != null) {
            errors.rejectValue("format","","Already exist");
        }
    }
}
