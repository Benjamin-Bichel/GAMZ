package Application.Controllers;


import Application.DataModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {


    @GetMapping
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

}

