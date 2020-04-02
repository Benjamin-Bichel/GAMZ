package Application.Controllers;

import Application.DataModel.*;
import Application.Exception.RecordNotFoundException;
import Application.Services.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProfessorController {

    @Autowired
    ProfService service;
    @Autowired ProfRepo repo;

   /* @GetMapping("/profApplication")
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
    } */

    @RequestMapping("/prof")
    public String getAllProfs(Model model)
    {
        List<Professor> list = service.getAllProfs();

        model.addAttribute("professors", list);
        return "list-profs";
    }

    @RequestMapping(path = {"/editProf", "/editProf/{id}"})
    public String editProfById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            Professor professor = service.getProfessorById(id.get());
            model.addAttribute("professor", professor);
        } else {
            model.addAttribute("professor", new Professor());
        }
        return "add-edit-prof";
    }

    @RequestMapping(path = "/deleteProf/{id}")
    public String deleteProfById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        service.deleteProfessorById(id);
        return "redirect:/prof";
    }

    @RequestMapping(path = "/createProf", method = RequestMethod.POST)
    public String createOrUpdateProf(Professor professor)
    {
        service.createOrUpdateProf(professor);
        return "redirect:/prof";
    }

}
