package Application.Controllers;

import Application.DataModel.*;
import Application.Exception.RecordNotFoundException;
import Application.Services.ApplicantService;
import Application.Services.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ApplicantController {
    @Autowired
    private ApplicantService service;
    @Autowired
    private FieldService fieldService;

    @RequestMapping("/applicant")
    public String getAllApplicants(Model model)
    {
        List<Applicant> list = service.getAllApplicants();

        model.addAttribute("applicants", list);
        return "list-applicants";
    }

    @RequestMapping(path = {"/editApplicant", "/editApplicant/{id}"})
    public String editApplicantById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            Applicant applicant = service.getApplicantById(id.get());
            model.addAttribute("fields", fieldService.getAllFields());
            model.addAttribute("applicant", applicant);
        } else {
            model.addAttribute("fields", fieldService.getAllFields());
            model.addAttribute("applicant", new Applicant());
        }
        return "add-edit-applicant";
    }

    @RequestMapping(path = "/deleteApplicant/{id}")
    public String deleteApplicantById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        service.deleteApplicantById(id);
        return "redirect:/applicant";
    }

    @RequestMapping(path = "/createApplicant", method = RequestMethod.POST)
    public String createOrUpdateApplicant(Applicant applicant)
    {
        service.createOrUpdateApplicant(applicant);
        return "redirect:/applicant";
    }


}
