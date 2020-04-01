package Application.Controllers;

import java.util.List;
import java.util.Optional;

import Application.DataModel.Applicant;
import Application.DataModel.User;
import Application.Services.ApplicantService;
import Application.Exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class MainController
{

    private static String UPLOADED_FOLDER = "F://temp//";

    @Autowired
    ApplicantService service;

    @GetMapping
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/applicant")
    public String getAllApplicants(Model model)
    {
        List<Applicant> list = service.getAllApplicants();

        model.addAttribute("applicants", list);
        return "list-applicants";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editApplicantById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            Applicant applicant = service.getApplicantById(id.get());
            model.addAttribute("applicant", applicant);
        } else {
            model.addAttribute("applicant", new Applicant());
        }
        return "add-edit-applicant";
    }

    @RequestMapping(path = "/delete/{id}")
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
