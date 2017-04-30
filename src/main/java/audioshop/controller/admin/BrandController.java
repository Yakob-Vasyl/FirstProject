package audioshop.controller.admin;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Brands;
import audioshop.service.BrandsService;
import audioshop.validator.BrandValidator;
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

import static audioshop.util.ParamBuilder.getParams;

/**
 * Created by vasya on 015 15 02 2017.
 */

@Controller
@RequestMapping("/admin/brands")
@SessionAttributes("brand")
public class BrandController {
    @Autowired
    private BrandsService brandsService;

    @InitBinder("brand")
    protected void bind(WebDataBinder binder) {
        binder.setValidator(new BrandValidator(brandsService));
    }

    @ModelAttribute("brand")
    public Brands getForm() {

        return new Brands();
    }
    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @GetMapping
    public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("page", brandsService.findAll(pageable,filter));
        return "admin-brands";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("brand", brandsService.findOne(id));
        show(model, pageable, filter);
        return "admin-brands";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        brandsService.delete(id);
        return "redirect:/admin/brands"+getParams(pageable,filter);
    }

    @PostMapping()
    public String save(@ModelAttribute("brand")@Valid Brands brand, BindingResult br,Model model, SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        if (br.hasErrors()) return show(model, pageable, filter);
        brandsService.save(brand);
        status.setComplete();
        return "redirect:/admin/brands"+getParams(pageable,filter);
    }


}
