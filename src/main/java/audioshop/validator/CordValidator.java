package audioshop.validator;

import audioshop.dto.form.CordForm;
import audioshop.entity.Cord;
import audioshop.service.CordService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Created by vasya on 027 27 02 2017.
 */
public class CordValidator implements Validator {

//    private final static Pattern REG = Pattern.compile("^([0-9]+)$");
    private final static Pattern REG = Pattern.compile("(\\d+)");
    private final CordService cordService;

    public CordValidator(CordService cordService) {
        this.cordService = cordService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CordForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CordForm form = (CordForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product_name", "", "Can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "material", "", "Can`t be empty");
        if(!REG.matcher(form.getPrice()).matches()){
            errors.rejectValue("price", "", "Enter number ");
        }
        if(!REG.matcher(form.getLength()).matches()){
            errors.rejectValue("length", "", "Enter number");
        }
        if(errors.getFieldError("price")==null&&errors.getFieldError("length")==null){
            if(cordService.findUnique(form.getProduct_name(), form.getBrand(), form.getConnection(),Integer.valueOf(form.getLength()), Integer.valueOf(form.getPrice()),form.getCategory())!=null){
                errors.rejectValue("product_name", "", "Already exist");
            }
        }
    }
}
