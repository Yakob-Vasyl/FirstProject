package audioshop.controller.admin;

import audioshop.dto.filter.CordFilter;
import audioshop.dto.form.CordForm;
import audioshop.editor.BrandEditor;
import audioshop.editor.CategoryEditor;
import audioshop.editor.ConnectorEditor;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Cord;
import audioshop.service.BrandsService;
import audioshop.service.CategoryService;
import audioshop.service.ConnectionService;
import audioshop.service.CordService;
import audioshop.util.ParamBuilder;
import audioshop.validator.CordValidator;
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
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by vasya on 017 17 02 2017.
 */
@Controller
@RequestMapping("/admin/cord")
@SessionAttributes("cord")
public class CordController {
    @Autowired
    private CordService cordService;
    @Autowired
    private ConnectionService connectionService;
    @Autowired
    private BrandsService brandsService;
    @Autowired
    private CategoryService categoryService;
    @InitBinder("cord")
    protected void bind(WebDataBinder binder) {
        binder.registerCustomEditor(Brands.class, new BrandEditor(brandsService));
        binder.registerCustomEditor(Connection.class, new ConnectorEditor(connectionService));
        binder.registerCustomEditor(Category.class,new CategoryEditor(categoryService));
        binder.setValidator(new CordValidator(cordService));
    }
    @ModelAttribute("cord")
    public CordForm getForm() {
        return new CordForm();
    }
    @ModelAttribute("filter")
    public CordFilter getFilter() {
        return new CordFilter();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") CordFilter filter) {
        model.addAttribute("cord", cordService.findForm(id));
        return show(model, pageable, filter);
    }
    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") CordFilter filter) {
        model.addAttribute("page", cordService.findAll(pageable,filter));
        model.addAttribute("connections", connectionService.findAll());
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "admin-cord";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute("cord") @Valid CordForm cordForm, BindingResult br, Model model, SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") CordFilter filter) {
        if(br.hasErrors()) return show(model, pageable,filter);
        cordService.save(cordForm);
        status.setComplete();
        return "redirect:/admin/cord"+getParams(pageable,filter);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter") CordFilter filter) {
        cordService.delete(id);
        return "redirect:/admin/cord"+getParams(pageable,filter);
    }
    private String getParams(Pageable pageable, CordFilter filter){
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
        if(!filter.getCordLength().isEmpty()){
            buffer.append("&cordLength=");
            buffer.append(filter.getCordLength());
        }
        return buffer.toString();
    }
}
