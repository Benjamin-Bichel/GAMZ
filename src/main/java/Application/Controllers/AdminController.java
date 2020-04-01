package Application.Controllers;

import Application.DataModel.*;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController{
    @Autowired
    private ProfRepo profreposiroty;

    @Autowired
    ApplicantService service;
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
    public String getAllApplicants(Model model) {
        List<Applicant> list = service.getAllApplicants();
        model.addAttribute("applicants", list);
        return "list-applicants";
    }


}
