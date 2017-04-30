package audioshop.controller.admin;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Format;
import audioshop.service.FormatService;
import audioshop.validator.FormatValidator;
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
 * Created by vasya on 016 16 02 2017.
 */
@Controller
@RequestMapping("/admin/format")
@SessionAttributes("format")
public class FormatController {
    @Autowired
    FormatService formatService;
    @InitBinder("format")
    protected void bind(WebDataBinder binder) {
        binder.setValidator(new FormatValidator(formatService));
    }

    @ModelAttribute("format")
    public Format getForm() {
        return new Format();
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }
    @GetMapping
    public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("page", formatService.findAll(pageable, filter));
        return "admin-format";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("format", formatService.findOne(id));
        show(model,pageable, filter);
        return "admin-format";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        formatService.delete(id);
        return "redirect:/admin/format"+getParams(pageable,filter);
    }

    @PostMapping()
    public String save(@ModelAttribute("format") @Valid Format format, BindingResult bindingResult,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        if (bindingResult.hasErrors()) return show(model,pageable, filter);
        formatService.save(format);
        status.setComplete();
        return "redirect:/admin/format"+getParams(pageable,filter);
    }
}
