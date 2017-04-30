package audioshop.controller.user.Player;

import audioshop.dto.filter.PlayerFilter;
import audioshop.entity.Category;
import audioshop.entity.Player;
import audioshop.service.*;
import audioshop.util.ParamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vasya on 002 02 03 2017.
 */
@Controller
public class PlayersSomeCategoryController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private FormatService formatService;
    @Autowired
    private BrandsService brandsService;

    @Autowired
    private ConnectionService connectionService;

   @ModelAttribute("filter")
    public PlayerFilter getFilter() {
        return new PlayerFilter();
    }

    @GetMapping(value = "/playersOfChosenCategory")
    public String show(Model model, @PageableDefault(size = 9) Pageable pageable, @ModelAttribute("filter") PlayerFilter filter) {
        model.addAttribute("page",  playerService.findAll(pageable, filter));
        model.addAttribute("formats", formatService.findAll());
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("connections", connectionService.findAll());
        return "user-playersOfChosenCategory";
    }
}
