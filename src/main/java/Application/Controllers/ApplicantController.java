package Application.Controllers;

import Application.DataModel.Applicant;
import Application.DataModel.ApplicantRepo;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicantController {
    @Autowired
    private ApplicantService service;
    private ApplicantRepo applicantRepo;

    @GetMapping("/applicantApplication")
    public String applicationForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "applicantApplication";
    }

    /*@PostMapping(path = "/add")
    public String addNewApplicant(String name, String email){
        Applicant applicant = new Applicant();
        applicant.setName(name);
        applicant.setEmail(email);
        applicantRepo.save(applicant);
        return "Saved";
    }*/

   /* @PostMapping("/")
    public String applicationResult(Model model, @ModelAttribute Applicant applicant) {
        return "result";

    }*/
}
