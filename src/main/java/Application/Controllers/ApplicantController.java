package Application.Controllers;

import Application.DataModel.Applicant;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicantController {
    @Autowired
    private ApplicantService service;

    @GetMapping("/applicant")
    public String applicationForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "applicant";
    }

    @PostMapping("/applicant")
    public String applicationResult(Model model, @ModelAttribute Applicant applicant) {
        return "result";
    }
}
