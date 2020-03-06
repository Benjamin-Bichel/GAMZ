package Controllers;

import DataModel.Applicant;
import DataModel.User;
import Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class ApplicantController {
    @Autowired
    private ApplicantService service;

    @GetMapping
    public String applicantForm(Model model, @ModelAttribute Applicant applicant){
        model.addAttribute("applicant", new Applicant());
        return "student";
    }

    @PostMapping
    public void applicationSubmit(@ModelAttribute Applicant user) {
        service.add(user);
        for(Applicant applicant : service.getApplicants()){
            System.out.println("Name: " + applicant.getName() + "Address: " + applicant.getAddress());
        }

    }




}
