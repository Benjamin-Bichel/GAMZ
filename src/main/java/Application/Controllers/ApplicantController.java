package Application.Controllers;

import Application.DataModel.*;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicantController {
    @Autowired
    private ApplicantService service;

    @GetMapping("/applicantApplication")
    public String applicationForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "applicantApplication";
    }

    @Autowired
    private ApplicantRepo applicantRepo;
    @PostMapping("/applicantApplication")
    public String applicantSubmit(@ModelAttribute Applicant applicant, @RequestParam String name, @RequestParam String email, String address) {
        Applicant a = new Applicant();
        a.setName(name);
        a.setEmail(email);
        a.setAddress(address);
        applicantRepo.save(a);
        return "applicantResult";

    }
}
