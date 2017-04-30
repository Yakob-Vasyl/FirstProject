package audioshop.controller.user.Player;

import audioshop.entity.Player;
import audioshop.entity.Product;
import audioshop.entity.ShopingCart;
import audioshop.entity.ShopingCart_;
import audioshop.service.PlayerService;
import audioshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.stream.Collectors;

/**
 * Created by vasya on 019 19 03 2017.
 */
@Controller
public class SelectedPlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private UserService userService;

    @GetMapping("/somePlayer/{id}")
    public String show(@PathVariable int id, Model model) {
        Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        model.addAttribute("formats", player.getFormats());
        model.addAttribute("connections", player.getConnections());
        return "user-somePlayer";
    }
    @GetMapping("/buy/player/{id}")
    public String buy(@PathVariable int id, Model model, Principal principal) {
        String email = principal.getName();
        audioshop.entity.User user = userService.findByEmail(email);
        Product product = playerService.findOne(id);
        ShopingCart shopingCart = new ShopingCart();
        shopingCart.setProduct(product);
        shopingCart.setUser(user);
        user.getShopingCarts().add(shopingCart);
        model.addAttribute("user", user);
        model.addAttribute("products", user.getShopingCarts().stream().map(ShopingCart::getProduct).collect(Collectors.toList()));
        return "user-basket";
    }
}
