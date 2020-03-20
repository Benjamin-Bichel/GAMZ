package Application.Controllers;

import Application.DataModel.*;
import Application.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

    @GetMapping("/profApplication")
    public String profForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "profApplication";
    }
    @PostMapping("/profApplication")
    public String profSubmit(@ModelAttribute Professor professor) {
        return "profResult";
    }
}
