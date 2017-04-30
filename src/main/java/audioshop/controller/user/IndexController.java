package audioshop.controller.user;

import audioshop.entity.Brands;
import audioshop.entity.Format;
import audioshop.entity.Player;
import audioshop.entity.User;
import audioshop.service.*;
import audioshop.validator.UserValidator;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

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

    @InitBinder("user")
    protected void bind(WebDataBinder binder) {
        binder.setValidator(new UserValidator(userService));
    }


    //
//    @Autowired
//    private FormatService formatService;
//
//    @Autowired
//    private ConnectionService connectionService;
//
//    @Autowired
//    private BrandsService brandsService;

    @GetMapping
    public String index(Model model) {
        return "user-index";
    }

    /* @RequestMapping(value = "/subCategoryPlayer/{subcategory}")
     public String player( @PathVariable String subcategory, Model model) {
         List<Player> playerList = playerService.findPlayersWithCategory(subcategory);
         model.addAttribute("players", playerList);
         // model.addAttribute("formats", player.getFormats());
         // model.addAttribute("connections", player.getConnections());
         return "user-subCategoryPlayer";
     }*/
    /*@RequestMapping(value = "/SubCategoryPlayer")
    public String playerCategory() {
        return "user-subCategoryPlayer";
    }

    @RequestMapping(value = "/SubCategoryPlayer/{subCategory}")
    public String player(@PathVariable String subCategory, Model model) {
        List<Player> playerList = playerService.findPlayersWithCategory(subCategory);
        model.addAttribute("players", playerList);
        // model.addAttribute("formats", player.getFormats());
        // model.addAttribute("connections", player.getConnections());
        return "user-subCategoryPlayer";
    }
    @RequestMapping(value = "/Format/{id}")
    public String showFormat(@PathVariable int id,Model model) {
        Format format = formatService.fetchFormatWithPlayers(id);
        model.addAttribute("players", format.getPlayers());
        return "user-playerThisWhithThisFormat";
    }*/

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

    }

