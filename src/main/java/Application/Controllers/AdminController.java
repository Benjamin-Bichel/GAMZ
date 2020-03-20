package Application.Controllers;

import Application.DataModel.*;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProfRepo profreposiroty;
    @Autowired
    private ApplicantRepo applicantRepo;

    @GetMapping
    public String adminForm(Model model, @ModelAttribute Admin admin){
        model.addAttribute("admin", new Admin());
        return "admin";
    }

    @GetMapping(path="/getProfs")
    public @ResponseBody
    Iterable<Professor> getAllProfs() {
        // This returns a JSON or XML with the users
        return profreposiroty.findAll();
    }

    @GetMapping(path="/getApplicants")
    public @ResponseBody
    Iterable<Applicant> getAllApplicants() {
        // This returns a JSON or XML with the users
        Iterable<Applicant> test = applicantRepo.findAll();
        return test;
    }
}
