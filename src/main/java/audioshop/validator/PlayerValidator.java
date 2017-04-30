package audioshop.validator;

import audioshop.dto.form.PlayerForm;
import audioshop.service.PlayerService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Created by vasya on 028 28 02 2017.
 */
public class PlayerValidator implements Validator {

    private final static Pattern REG = Pattern.compile("(\\d+)");

    private final PlayerService playerService;

    public PlayerValidator(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PlayerForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PlayerForm form = (PlayerForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"product_name", "", "Can`t be empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bandwidth", "", "Can`t be empty");

        if(!REG.matcher(form.getSample_rate()).matches()){
            errors.rejectValue("sample_rate", "", "Enter number ");
        }
        if(!REG.matcher(form.getSignal_noise()).matches()){
            errors.rejectValue("signal_noise", "", "Enter number");
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
        if(errors.getFieldError("sample_rate")==null&&errors.getFieldError("signal_noise")==null&&errors.getFieldError("power")==null&&errors.getFieldError("weight")==null&&errors.getFieldError("price")==null){
            if(playerService.findUnique(form.getProductName(), form.getBrand(),form.getCategory(), Integer.valueOf(form.getSample_rate()),Integer.valueOf(form.getSignal_noise()),Integer.valueOf(form.getPower()),form.getBandwidth())!=null){
                errors.rejectValue("product_name", "", "Already exist");
            }
        }

    }
}
