package audioshop.controller.admin;

import audioshop.dto.filter.SpeakersFilter;
import audioshop.dto.form.SpeakersForm;
import audioshop.editor.BrandEditor;
import audioshop.editor.CategoryEditor;
import audioshop.editor.ConnectorEditor;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Speakers;
import audioshop.service.BrandsService;
import audioshop.service.CategoryService;
import audioshop.service.ConnectionService;
import audioshop.service.SpeakersService;
import audioshop.util.ParamBuilder;
import audioshop.validator.SpeakersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import static audioshop.util.ParamBuilder.*;
/**
 * Created by vasya on 019 19 02 2017.
 */
@Controller
@RequestMapping("/admin/speakers")
@SessionAttributes("speaker")
public class SpeakersController {
    @Autowired
    private SpeakersService speakersService;

    @Autowired
    private BrandsService brandsService;

    @Autowired
    private ConnectionService connectionService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("speaker")
    public SpeakersForm getForm() {
        return new SpeakersForm();
    }

    @ModelAttribute("filter")
    public SpeakersFilter getFilter() {
        return new SpeakersFilter();
    }

    @InitBinder("speaker")
    protected void bind(WebDataBinder binder) {
        binder.registerCustomEditor(Brands.class,new BrandEditor(brandsService));
        binder.registerCustomEditor(Connection.class,new ConnectorEditor(connectionService));
        binder.registerCustomEditor(Category.class,new CategoryEditor(categoryService));
        binder.setValidator(new SpeakersValidator(speakersService));
    }
    @GetMapping
    public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SpeakersFilter filter) {
        model.addAttribute("page",speakersService.findAll(pageable,filter));
        model.addAttribute("brands",brandsService.findAll());
        model.addAttribute("connections",connectionService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "admin-speakers";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SpeakersFilter filter) {
        model.addAttribute("speaker", speakersService.findForm(id));
        return show(model, pageable,filter);
    }

    @PostMapping
    public String save(@ModelAttribute("speaker") @Valid SpeakersForm form, BindingResult bindingResult, Model model, SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") SpeakersFilter filter) {
        if (bindingResult.hasErrors()) return show(model, pageable,filter);
        speakersService.save(form);
        status.setComplete();
        return "redirect:/admin/speakers"+getParams(pageable,filter);
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter") SpeakersFilter filter) {
        speakersService.delete(id);
        return "redirect:/admin/speakers"+getParams(pageable, filter);
    }
    private String getParams(Pageable pageable, SpeakersFilter filter){
        String page = ParamBuilder.getParams(pageable);
        StringBuilder buffer = new StringBuilder(page);
        if(!filter.getMaxPrice().isEmpty()){
            buffer.append("&maxPrice=");
            buffer.append(filter.getMaxPrice());
        }
        if(!filter.getMinPrice().isEmpty()){
            buffer.append("&minPrice=");
            buffer.append(filter.getMinPrice());
        }
        if(!filter.getBrandId().isEmpty()){
            for (Integer id : filter.getBrandId()) {
                buffer.append("&brandId=");
                buffer.append(id);
            }
        }
        if(!filter.getConnectionId().isEmpty()){
            for (Integer id : filter.getConnectionId()) {
                buffer.append("&connectionId=");
                buffer.append(id);
            }
        }
        return buffer.toString();
    }
}
