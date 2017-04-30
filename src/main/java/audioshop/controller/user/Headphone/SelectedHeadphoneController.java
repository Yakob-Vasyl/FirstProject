package audioshop.controller.user.Headphone;

import audioshop.entity.Headphone;
import audioshop.service.HeadphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by vasya on 021 21 03 2017.
 */
@Controller
public class SelectedHeadphoneController {
    @Autowired
    private HeadphoneService headphoneService;

    @GetMapping("/someHeadphone/{id}")
    public String show(@PathVariable int id, Model model) {
        Headphone headphone  = headphoneService.findOne(id);
        model.addAttribute("headphone", headphone);
        return "user-someHeadphone";
    }
}
