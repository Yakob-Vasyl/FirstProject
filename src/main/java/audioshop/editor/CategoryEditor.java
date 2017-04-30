package audioshop.editor;

import audioshop.entity.Category;
import audioshop.service.CategoryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by vasya on 015 15 03 2017.
 */
public class CategoryEditor extends PropertyEditorSupport {
    private final CategoryService service;

    public CategoryEditor(CategoryService service) {
        this.service = service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Category category = service.findOne(Integer.valueOf(text));
        setValue(category);
    }
}
