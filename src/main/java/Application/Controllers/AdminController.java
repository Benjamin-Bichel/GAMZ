package Application.Controllers;

import Application.DataModel.*;
import Application.Services.ApplicantService;
import Application.Services.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class

AdminController{
    @Autowired
    private ProfRepo profreposiroty;
    @Autowired
    ApplicantService applicantService;
    @Autowired
    ProfService profService;

    @GetMapping
    public String adminForm(Model model, @ModelAttribute Admin admin){
        model.addAttribute("admin", new Admin());
        return "admin";
    }

    @GetMapping(path="/profListing")
    public String getAllProfessors(Model model) {
        List<Professor> list = profService.getAllProfs();
        model.addAttribute("professors", list);
        return "list-profs";
    }


    @GetMapping(path="/applicantListing")
    public String getAllApplicants(Model model) {
        List<Applicant> list = applicantService.getAllApplicants();
        model.addAttribute("applicants", list);
        return "list-applicants";
    }


}
