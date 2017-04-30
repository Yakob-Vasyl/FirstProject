package audioshop.controller.user.Speakers;

import audioshop.service.SpeakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by vasya on 021 21 03 2017.
 */
@Controller
public class CategorySpeakersController {


    @Autowired
    private SpeakersService speakersService;

    @GetMapping("/CategorySpeakers")
    public String show(Model model) {
        model.addAttribute("KOM5brands", speakersService.getBrandsFromSpeakers(7));
        model.addAttribute("NASTbrands", speakersService.getBrandsFromSpeakers(8));
        model.addAttribute("SABbrands", speakersService.getBrandsFromSpeakers(9));
        model.addAttribute("VBUDbrands", speakersService.getBrandsFromSpeakers(10));
        return "user-CategorySpeakers";
    }
}
