package Application.Controllers;

import Application.DataModel.Admin;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private ApplicantService service;

    @GetMapping
    public String adminForm(Model model, @ModelAttribute Admin admin){
        model.addAttribute("admin", new Admin());
        return "admin";
    }

}
