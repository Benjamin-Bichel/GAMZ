package Application.Controllers;

import Application.DataModel.Applicant;
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
    public String applicantForm(Model model, @ModelAttribute Applicant applicant){
        model.addAttribute("applicant", new Applicant());
        return "applicant";
    }

}
