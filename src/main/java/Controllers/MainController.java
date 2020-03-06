package Controllers;


import DataModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLogin(Model model) {
        model.addAttribute("user", new User());
        return "student";
    }
    */

    @GetMapping("/")
    public String applicationForm(Model model) {
        model.addAttribute("user", new User());
        return "student";
    }

    @PostMapping("/")
    public String applicationSubmit(@ModelAttribute User user) {
        return "result";
    }

}

