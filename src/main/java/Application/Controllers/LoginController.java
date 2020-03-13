package Application.Controllers;


import Application.DataModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {


    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLogin(Model model) {
        model.addAttribute("user", new User());
        return "student";
    }
    */

    @GetMapping
    public String applicationForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }



}

