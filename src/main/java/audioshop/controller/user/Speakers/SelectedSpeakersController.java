package audioshop.controller.user.Speakers;

import audioshop.entity.Speakers;
import audioshop.service.SpeakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by vasya on 021 21 03 2017.
 */
@Controller
public class SelectedSpeakersController {
    @Autowired
    private SpeakersService speakersService;

    @GetMapping("/someSpeakers/{id}")
    public String show(@PathVariable int id, Model model) {
        Speakers speakers  = speakersService.findOne(id);
        model.addAttribute("headphone", speakers);
        return "user-someSpeakers";
    }
}

