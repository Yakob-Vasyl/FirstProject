package audioshop.controller.user.Cord;

import audioshop.dto.filter.CordFilter;
import audioshop.service.BrandsService;
import audioshop.service.ConnectionService;
import audioshop.service.CordService;
import audioshop.service.FormatService;
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
public class CordsSomeCategoryController {

    @Autowired
    private CordService cordService;
  
    @Autowired
    private BrandsService brandsService;

    @Autowired
    private ConnectionService connectionService;

    @ModelAttribute("filter")
    public CordFilter getFilter() {
        return new CordFilter();
    }

    @GetMapping(value = "/cordsOfChosenCategory")
    public String show(Model model, @PageableDefault(size = 9) Pageable pageable, @ModelAttribute("filter") CordFilter filter) {
        model.addAttribute("page",  cordService.findAll(pageable, filter));
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("connections", connectionService.findAll());
        return "user-cordsOfChosenCategory";
    }
}

