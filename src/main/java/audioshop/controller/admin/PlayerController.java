package audioshop.controller.admin;

import audioshop.dto.filter.PlayerFilter;
import audioshop.dto.form.PlayerForm;
import audioshop.editor.BrandEditor;
import audioshop.editor.CategoryEditor;
import audioshop.editor.ConnectorEditor;
import audioshop.editor.FormatEditor;
import audioshop.entity.*;
import audioshop.service.*;
import audioshop.util.ParamBuilder;
import audioshop.validator.PlayerValidator;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static audioshop.util.ParamBuilder.*;
/**
 * Created by vasya on 015 15 02 2017.
 */
@Controller
@RequestMapping("/admin/player")
@SessionAttributes("player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private ConnectionService connectionService;
    @Autowired
    private FormatService formatService;
    @Autowired
    private BrandsService brandsService;
    @Autowired
    private CategoryService categoryService;

    @InitBinder("player")
    protected void bind(WebDataBinder binder) {
        binder.registerCustomEditor(Brands.class, new BrandEditor(brandsService));
        binder.registerCustomEditor(Format.class, new FormatEditor(formatService));
        binder.registerCustomEditor(Connection.class, new ConnectorEditor(connectionService));
        binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
        binder.setValidator(new PlayerValidator(playerService));
    }
    @ModelAttribute("player")
    public PlayerForm getForm() {
        return new PlayerForm();
    }

    @ModelAttribute("filter")
    public PlayerFilter getFilter() {
        return new PlayerFilter();
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") PlayerFilter filter) {
        model.addAttribute("player", playerService.findForm(id));
        return show(model,pageable,filter);
    }
    @GetMapping
    public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") PlayerFilter filter) {
        model.addAttribute("page", playerService.findAll(pageable,filter));
        model.addAttribute("formats", formatService.findAll());
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("connections", connectionService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "admin-player";
    }

    @PostMapping
    public String save(@ModelAttribute("player") @Valid PlayerForm form, BindingResult bindingResult, Model model, SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") PlayerFilter filter) {
        if (bindingResult.hasErrors()) return show(model,pageable,filter);
        playerService.save(form);
        status.setComplete();
        return "redirect:/admin/player"+getParams(pageable,filter);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter") PlayerFilter filter) {
        playerService.delete(id);
        return "redirect:/admin/player"+getParams(pageable,filter);
    }
    private String getParams(Pageable pageable, PlayerFilter filter){
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
        if(!filter.getFormatId().isEmpty()){
            for (Integer id : filter.getFormatId()) {
                buffer.append("&formatId=");
                buffer.append(id);
            }
        }
        return buffer.toString();
    }
}
