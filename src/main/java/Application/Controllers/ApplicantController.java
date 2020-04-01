package Application.Controllers;

import Application.DataModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ApplicantController {
    @Autowired
    private ApplicantRepo applicantRepo;

    @Autowired
    public ApplicantController(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }
    /*@GetMapping("/applicantApplication")
    public String applicationForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "applicantApplication";
    }
*/
    /*@PostMapping("/applicantApplication")
    public String applicantSubmit(@ModelAttribute Applicant applicant, @RequestParam String name, @RequestParam String email, String address) {
        Applicant a = new Applicant();
        a.setName(name);
        a.setEmail(email);
        a.setAddress(address);
        applicantRepo.save(a);
        return "applicantResult";

    }*/



}
