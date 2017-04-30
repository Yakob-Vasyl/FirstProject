package audioshop.editor;

import audioshop.entity.Format;
import audioshop.service.FormatService;

import java.beans.PropertyEditorSupport;

/**
 * Created by vasya on 022 22 02 2017.
 */
public class FormatEditor extends PropertyEditorSupport{

    private final FormatService formatService;

    public FormatEditor(FormatService formatService) {
        this.formatService = formatService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Format format = formatService.findOne(Integer.valueOf(text));
        setValue(format);
    }
}
