package audioshop.controller.user.Cord;

import audioshop.service.CordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vasya on 004 04 03 2017.
 */
@Controller
public class CategoryCordController {

    @Autowired
    private CordService cordService;

    @RequestMapping("/CategoryCord")
    public String show(Model model) {

        model.addAttribute("MZBLOCKbrands", cordService.getBrandsFromCord(17));
        model.addAttribute("ACUSTbrands",cordService.getBrandsFromCord(18));
        model.addAttribute("HDMIbrands",cordService.getBrandsFromCord(19));
        model.addAttribute("DIGITbrands",cordService.getBrandsFromCord(20));
        model.addAttribute("OPTbrands",cordService.getBrandsFromCord(21));
    return "user-CategoryCord";
    }



}
