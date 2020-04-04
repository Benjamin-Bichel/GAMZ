package Application.Controllers;

import Application.DataModel.*;
import Application.Exception.RecordNotFoundException;
import Application.Services.FieldService;
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
    @Autowired
    FieldService fieldService;
    @Autowired
    ProfRepo repo;

    @RequestMapping("/prof")
    public String getAllProfs(Model model)
    {
        List<Professor> list = service.getAllProfs();
        List<Field> listOfFields = fieldService.getAllFields();
        model.addAttribute("professors", list);
        model.addAttribute("fields", listOfFields);
        return "list-profs";
    }

    @RequestMapping(path = {"/profEdit", "/profEdit/{id}"})
    public String editProfById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            Professor professor = service.getProfessorById(id.get());
            model.addAttribute("fields", fieldService.getAllFields());
            model.addAttribute("professor", professor);
        } else {
            model.addAttribute("fields", fieldService.getAllFields());
            model.addAttribute("professor", new Professor());
        }
        return "add-edit-prof";
    }

    @RequestMapping(path = "/profDelete/{id}")
    public String deleteProfById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        service.deleteProfessorById(id);
        return "redirect:/prof";
    }

    @RequestMapping(path = "/profCreate", method = RequestMethod.POST)
    public String createOrUpdateProf(Professor professor)
    {
        service.createOrUpdateProf(professor);
        return "redirect:/prof";
    }


    @RequestMapping(path = "/fieldEdit")
    public String editField(Model model){
        model.addAttribute("field", new Field());
        return "add-edit-Field";
    }

/*@RequestMapping(path = "/fieldDelete")
    public String deleteField(Field field) {
        fieldService.deleteField(field.getField());
        return "redirect:/prof";
    }*/




    @RequestMapping(path = "/fieldCreate", method = RequestMethod.POST)
    public String createOrUpdateField(Field field){
        fieldService.createField(field);
        return "redirect:/prof";
    }

}
