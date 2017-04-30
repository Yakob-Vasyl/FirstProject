package audioshop.editor;

import audioshop.entity.Brands;
import audioshop.service.BrandsService;

import java.beans.PropertyEditorSupport;

/**
 * Created by vasya on 022 22 02 2017.
 */
public class BrandEditor extends PropertyEditorSupport {

    private final BrandsService brandsService;

    public BrandEditor( BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Brands brand = brandsService.findOne(Integer.valueOf(text));
        setValue(brand);
    }
}
