package audioshop.controller.user.Speakers;

import audioshop.dto.filter.SpeakersFilter;
import audioshop.service.BrandsService;
import audioshop.service.ConnectionService;
import audioshop.service.SpeakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by vasya on 021 21 03 2017.
 */
@Controller
public class SpeakersSomeCategoryController {
    @Autowired
    private SpeakersService speakersService;

    @Autowired
    private BrandsService brandsService;

    @Autowired
    private ConnectionService connectionService;

    @ModelAttribute("filter")
    public SpeakersFilter getFilter() {
        return new SpeakersFilter();
    }

    @GetMapping(value = "/speakersOfChosenCategory")
    public String show(Model model, @PageableDefault(size = 9) Pageable pageable, @ModelAttribute("filter") SpeakersFilter filter) {
        model.addAttribute("page",  speakersService.findAll(pageable, filter));
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("connections", connectionService.findAll());
        return "user-speakersOfChosenCategory";
    }
}

