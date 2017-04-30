package audioshop.controller.admin;

import audioshop.dto.filter.HeadphoneFilter;
import audioshop.dto.form.HeadphoneForm;
import audioshop.editor.BrandEditor;
import audioshop.editor.CategoryEditor;
import audioshop.editor.ConnectorEditor;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Headphone;
import audioshop.service.BrandsService;
import audioshop.service.CategoryService;
import audioshop.service.ConnectionService;
import audioshop.service.HeadphoneService;
import audioshop.util.ParamBuilder;
import audioshop.validator.HeadphoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import static audioshop.util.ParamBuilder.*;

import javax.validation.Valid;

/**
 * Created by vasya on 019 19 02 2017.
 */
@Controller
@RequestMapping("/admin/headphone")
@SessionAttributes("headphone")
public class HeadphonesController {
    @Autowired
    private HeadphoneService headphoneService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private BrandsService brandsService;

    @Autowired
    private CategoryService categoryService;
    @InitBinder("headphone")
    protected void bind(WebDataBinder binder) {
        binder.registerCustomEditor(Brands.class, new BrandEditor(brandsService));
        binder.registerCustomEditor(Connection.class, new ConnectorEditor(connectionService));
        binder.registerCustomEditor(Category.class,new CategoryEditor(categoryService));
        binder.setValidator(new HeadphoneValidator(headphoneService));
    }
    @ModelAttribute("headphone")
    public HeadphoneForm getForm() {

        return new HeadphoneForm();
    }
    @ModelAttribute("filter")
    public HeadphoneFilter getFilter() {
        return new HeadphoneFilter();
    }

    @GetMapping
    public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") HeadphoneFilter filter) {

        model.addAttribute("page", headphoneService.findAll(pageable,filter));
        model.addAttribute("connections", connectionService.findAll());
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        return "admin-headphone";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") HeadphoneFilter filter) {
        model.addAttribute("headphone", headphoneService.findForm(id));
        return show(model,pageable,filter);
    }
    @PostMapping
    public String save(@ModelAttribute("headphone") @Valid HeadphoneForm form, BindingResult bindingResult, Model model, SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") HeadphoneFilter filter) {
        if(bindingResult.hasErrors()) return show(model,pageable,filter);
        headphoneService.save(form);
        status.setComplete();
        return "redirect:/admin/headphone"+getParams(pageable,filter);
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter") HeadphoneFilter filter) {
        headphoneService.delete(id);
        return "redirect:/admin/headphone"+getParams(pageable,filter);
    }
    private String getParams(Pageable pageable, HeadphoneFilter filter){
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
