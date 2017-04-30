package audioshop.controller.user.Player;

import audioshop.entity.Player;
import audioshop.service.BrandsService;
import audioshop.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by vasya on 002 02 03 2017.
 */
@Controller
public class CategoryPlayerController {
    @Autowired
    private BrandsService brandsService;
    @Autowired
    private PlayerService playerService;


    @RequestMapping("/CategoryPlayer")
    public String show(Model model) {

        model.addAttribute("CDbrands", playerService.getBrandsFromPlayer(1));
        model.addAttribute("ZAPbrands",playerService.getBrandsFromPlayer(2));
        model.addAttribute("STEREORESbrands",playerService.getBrandsFromPlayer(3));
        model.addAttribute("MEREZbrands",playerService.getBrandsFromPlayer(4));
        model.addAttribute("MINIHIFIbrands",playerService.getBrandsFromPlayer(5));
        model.addAttribute("CDRESbrands",playerService.getBrandsFromPlayer(6));
        return "user-CategoryPlayer";
    }

    /*@RequestMapping(value = "/subCategoryPlayer")
    public String player( Model model) {
        List<Player> playerList = playerService.findPlayersWithCategory("ЦАП");
        model.addAttribute("players", playerList);
        // model.addAttribute("formats", player.getFormats());
        // model.addAttribute("connections", player.getConnections());
        return "user-subCategoryPlayer";
    }*/

}
