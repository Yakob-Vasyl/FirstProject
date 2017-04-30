package audioshop.validator;

import audioshop.dto.form.HeadphoneForm;
import audioshop.service.HeadphoneService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Created by vasya on 028 28 02 2017.
 */
public class HeadphoneValidator implements Validator {
    private final HeadphoneService headphoneService;

    private final static Pattern REG = Pattern.compile("(\\d+)");
    public HeadphoneValidator(HeadphoneService headphoneService) {
        this.headphoneService = headphoneService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return HeadphoneForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HeadphoneForm form = (HeadphoneForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"product_name","","Can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "frequency_range", "", "Can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "", "Can`t be empty");
        if(!REG.matcher(form.getPrice()).matches()){
            errors.rejectValue("price", "", "Enter number ");
        }
        if(!REG.matcher(form.getCord_length()).matches()){
            errors.rejectValue("cord_length", "", "Enter number");
        }
        /*String product_name, Brands brand, Connection connection, int resistance,int cordLength ,int sensitivity, String subCategory, int price*/
        if(errors.getFieldError("price")==null&&errors.getFieldError("cord_length")==null){
            if(headphoneService.findUnique(form.getProduct_name(), form.getBrand(), form.getConnection(),Integer.valueOf(form.getResistance()),Integer.valueOf(form.getCord_length()),Integer.valueOf(form.getSensitivity()),form.getCategory(),Integer.valueOf(form.getPrice()))!=null){
                errors.rejectValue("product_name", "", "Already exist");
            }
        }
    }
}
