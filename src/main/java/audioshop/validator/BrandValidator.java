package audioshop.validator;

import audioshop.entity.Brands;
import audioshop.service.BrandsService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vasya on 027 27 02 2017.
 */
public class BrandValidator implements Validator {

    private final BrandsService brandsService;

    public BrandValidator(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Brands.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Brands brand = (Brands) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "", "Can`t be empty");
        if (brandsService.findByBrand(brand.getBrand()) != null) {
            errors.rejectValue("brand","","Already exist");
        }
    }
}
