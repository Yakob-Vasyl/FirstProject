package audioshop.controller.user.Cord;

import audioshop.entity.Cord;
import audioshop.service.CordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by vasya on 021 21 03 2017.
 */
@Controller
public class SelectedCordController {
    @Autowired
    private CordService cordService;

    @GetMapping("/someCord/{id}")
    public String show(@PathVariable int id, Model model) {
        Cord cord  = cordService.findOne(id);
        model.addAttribute("cord", cord);
        return "user-someCord";
    }
}
