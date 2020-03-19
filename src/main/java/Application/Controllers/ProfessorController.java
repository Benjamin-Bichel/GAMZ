package Application.Controllers;

import Application.DataModel.Professor;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Prof")
public class ProfessorController {
    @Autowired
    private ApplicantService service;

    @GetMapping
    public String profForm(Model model, @ModelAttribute Professor professor){
        model.addAttribute("prof", new Professor());
        return "prof";
    }
}
