package audioshop.controller.user.Speakers;

import audioshop.entity.Product;
import audioshop.entity.ShopingCart;
import audioshop.entity.Speakers;
import audioshop.service.ShopingCartService;
import audioshop.service.SpeakersService;
import audioshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

/**
 * Created by vasya on 021 21 03 2017.
 */
@Controller
public class SelectedSpeakersController {
    @Autowired
    private SpeakersService speakersService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopingCartService cartService;

    @GetMapping("/someSpeakers/{id}")
    public String show(@PathVariable int id, Model model) {
        Speakers speakers  = speakersService.findOne(id);
        model.addAttribute("headphone", speakers);
        return "user-someSpeakers";
    }
    @GetMapping("/buy/speakers/{id}")
    public String addToBasket(@PathVariable int id, Model model, Principal principal) {
        String email = principal.getName();
        audioshop.entity.User user = userService.findByEmail(email);
        Product product = speakersService.findOne(id);
        ShopingCart shopingCart = new ShopingCart();
        shopingCart.setProduct(product);
        shopingCart.setUser(user);
        cartService.save(shopingCart);
        user.getShopingCarts().add(shopingCart);
        return show(id, model);
    }
}

