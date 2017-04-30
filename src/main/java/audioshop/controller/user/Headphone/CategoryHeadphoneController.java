package audioshop.controller.user.Headphone;

import audioshop.service.HeadphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by vasya on 021 21 03 2017.
 */
@Controller
public class CategoryHeadphoneController {
    @Autowired
    private HeadphoneService headphoneService;

    @GetMapping("/CategoryHeadphone")
    public String show(Model model) {
        model.addAttribute("VKLDbrands", headphoneService.getBrandsFromHeadphones(13));
        model.addAttribute("VAKUMbrands",headphoneService.getBrandsFromHeadphones(14));
        model.addAttribute("NAKLADbrands",headphoneService.getBrandsFromHeadphones(15));
        model.addAttribute("BEZPRVDbrands",headphoneService.getBrandsFromHeadphones(16));
        return "user-CategoryHeadphone";
    }

    
    
}
    
