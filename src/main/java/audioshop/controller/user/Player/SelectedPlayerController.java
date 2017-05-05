package audioshop.controller.user.Player;

import audioshop.entity.Player;
import audioshop.entity.Product;
import audioshop.entity.ShopingCart;
import audioshop.service.PlayerService;
import audioshop.service.ShopingCartService;
import audioshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

/**
 * Created by vasya on 019 19 03 2017.
 */
@Controller
public class SelectedPlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private UserService userService;
    @Autowired
    private ShopingCartService cartService;

    @GetMapping("/somePlayer/{id}")
    public String show(@PathVariable int id, Model model) {
        Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        model.addAttribute("formats", player.getFormats());
        model.addAttribute("connections", player.getConnections());
        return "user-somePlayer";
    }

    @GetMapping("/buy/player/{id}")
    public String addToBasket(@PathVariable int id, Model model, Principal principal) {
        String email = principal.getName();
        audioshop.entity.User user = userService.findByEmail(email);
        Product product = playerService.findOne(id);
        ShopingCart shopingCart = new ShopingCart();
        shopingCart.setProduct(product);
        shopingCart.setUser(user);
        cartService.save(shopingCart);
        user.getShopingCarts().add(shopingCart);
        return show(id, model);
    }
}
