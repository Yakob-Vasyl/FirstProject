package audioshop.validator;

import audioshop.dto.form.SpeakersForm;
import audioshop.service.SpeakersService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Created by vasya on 028 28 02 2017.
 */
public class SpeakersValidator implements Validator {
    private final static Pattern REG = Pattern.compile("(\\d+)");
    private final SpeakersService speakersService;

    public SpeakersValidator(SpeakersService speakersService) {
        this.speakersService = speakersService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SpeakersForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SpeakersForm form = (SpeakersForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"product_name","","Can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"frequency_range","","Can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"color","","Can`t be empty");
        if(!REG.matcher(form.getImpedance()).matches()){
            errors.rejectValue("impedance", "", "Enter number ");
        }
        if(!REG.matcher(form.getSensitivity()).matches()){
            errors.rejectValue("sensitivity", "", "Enter number");
        }
        if(!REG.matcher(form.getPower()).matches()){
            errors.rejectValue("power", "", "Enter number ");
        }
        if(!REG.matcher(form.getWeight()).matches()){
            errors.rejectValue("weight", "", "Enter number");
        }
        if(!REG.matcher(form.getPrice()).matches()){
            errors.rejectValue("price", "", "Enter number");
        }
        if(errors.getFieldError("impedance")==null&&errors.getFieldError("sensitivity")==null&&errors.getFieldError("power")==null&&errors.getFieldError("weight")==null&&errors.getFieldError("price")==null){
            if(speakersService.findUnique(form.getProduct_name(), form.getBrand(), form.getConnection(),form.getCategory(),Integer.valueOf(form.getImpedance()),Integer.valueOf(form.getSensitivity()),Integer.valueOf(form.getPower()),form.getColor())!=null){
                errors.rejectValue("product_name", "", "Already exist");
            }
        }

    }
}
