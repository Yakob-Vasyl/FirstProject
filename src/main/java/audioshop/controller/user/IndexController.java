package audioshop.controller.user;

import audioshop.entity.ShopingCart;
import audioshop.entity.User;
import audioshop.service.PlayerService;
import audioshop.service.ShopingCartService;
import audioshop.service.UserService;
import audioshop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.stream.Collectors;

/**
 * Created by vasya on 008 08 02 2017.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private UserService userService;
    @Autowired
    private ShopingCartService cartService;

    @InitBinder("user")
    protected void bind(WebDataBinder binder) {
        binder.setValidator(new UserValidator(userService));
    }

    @GetMapping
    public String index(Model model) {
        return "user-index";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin-admin";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "user-registration";
    }

    @PostMapping("/registration")
    public String save(@ModelAttribute("user") @Valid User user){

        userService.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "user-login";
    }

    @GetMapping("/basket")
    public String showBasket(Model model, Principal principal) {
        String email = principal.getName();
        audioshop.entity.User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("userName", principal.getName());
        model.addAttribute("shopingCart", user.getShopingCarts());
        return "user-basket";
    }

    @GetMapping("/basket/delete/{id}")
    public String deleteCart(@PathVariable int id) {
        cartService.delete(id);
        return "redirect:/basket";
    }
}



