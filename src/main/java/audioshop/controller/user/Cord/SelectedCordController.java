package audioshop.controller.user.Cord;

import audioshop.entity.Cord;
import audioshop.entity.Product;
import audioshop.entity.ShopingCart;
import audioshop.service.CordService;
import audioshop.service.ShopingCartService;
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
public class SelectedCordController {
    @Autowired
    private CordService cordService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopingCartService cartService;
    @GetMapping("/someCord/{id}")
    public String show(@PathVariable int id, Model model) {
        Cord cord  = cordService.findOne(id);
        model.addAttribute("cord", cord);
        return "user-someCord";
    }
    @GetMapping("/buy/cord/{id}")
    public String addToBasket(@PathVariable int id, Model model, Principal principal) {
        String email = principal.getName();
        audioshop.entity.User user = userService.findByEmail(email);
        Product product = cordService.findOne(id);
        ShopingCart shopingCart = new ShopingCart();
        shopingCart.setProduct(product);
        shopingCart.setUser(user);
        cartService.save(shopingCart);
        user.getShopingCarts().add(shopingCart);
        return show(id, model);
    }
}
