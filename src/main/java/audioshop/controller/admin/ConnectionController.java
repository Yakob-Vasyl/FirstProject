package audioshop.controller.admin;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Connection;
import audioshop.service.ConnectionService;
import audioshop.validator.ConnectionValidator;
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
@RequestMapping("admin/connection")
@SessionAttributes("connection")
public class ConnectionController {
    @Autowired
    ConnectionService connectionService;
    @InitBinder("connection")
    protected void bind(WebDataBinder binder) {
        binder.setValidator(new ConnectionValidator(connectionService));
    }

    @ModelAttribute("connection")
    public Connection getForm() {
        return new Connection();
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("connection", connectionService.findOne(id));
        show(model,pageable, filter);
        return "admin-connection";
    }

    @GetMapping
    public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("page", connectionService.findAll(pageable, filter));
        return "admin-connection";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        connectionService.delete(id);
        return "redirect:/admin/connection"+getParams(pageable,filter);
    }
    @PostMapping()
    public String save(@ModelAttribute("connection") @Valid Connection connection, BindingResult bindingResult,Model model, SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        if (bindingResult.hasErrors()) {
            return show(model,pageable, filter);
        }
        connectionService.save(connection);
        status.setComplete();
        return "redirect:/admin/connection"+getParams(pageable,filter);
    }

}
