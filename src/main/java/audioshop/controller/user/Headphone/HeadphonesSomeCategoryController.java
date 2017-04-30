package audioshop.controller.user.Headphone;

import audioshop.dto.filter.HeadphoneFilter;
import audioshop.service.BrandsService;
import audioshop.service.ConnectionService;
import audioshop.service.HeadphoneService;
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
public class HeadphonesSomeCategoryController {
    @Autowired
    private HeadphoneService headphoneService;
   
    @Autowired
    private BrandsService brandsService;

    @Autowired
    private ConnectionService connectionService;

    @ModelAttribute("filter")
    public HeadphoneFilter getFilter() {
        return new HeadphoneFilter();
    }


    @GetMapping(value = "/headphonesOfChosenCategory")
    public String show(Model model, @PageableDefault(size = 9) Pageable pageable, @ModelAttribute("filter") HeadphoneFilter filter) {
        model.addAttribute("page",  headphoneService.findAll(pageable, filter));
        model.addAttribute("brands", brandsService.findAll());
        model.addAttribute("connections", connectionService.findAll());
        return "user-headphonesOfChosenCategory";
    }

}

