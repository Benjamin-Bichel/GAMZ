package Application.Controllers;

import Application.DataModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {

    @GetMapping("/profApplication")
    public String profForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "profApplication";
    }

    @Autowired
    private ProfRepo profreposiroty;
    @PostMapping("/profApplication")
    public String profSubmit(@ModelAttribute Professor professor, @RequestParam String name, @RequestParam String research) {
        Professor p = new Professor();
        p.setName(name);
        p.setResearch(research);
        profreposiroty.save(p);
        return "profResult";

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Professor> getAllUsers() {
        // This returns a JSON or XML with the users
        return profreposiroty.findAll();
    }
}
