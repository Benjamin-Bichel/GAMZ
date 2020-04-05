package Application.Controllers;

import Application.App;
import Application.DataModel.*;
import Application.Exception.RecordNotFoundException;
import Application.Services.ApplicantService;
import Application.Services.FieldService;
import Application.Services.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class AdminController{

    @Autowired
    ApplicantService applicantService;
    @Autowired
    ProfService profService;
    @Autowired
    FieldService fieldService;

    @RequestMapping("/admin")
    public String adminForm(Model model, @ModelAttribute Admin admin){
        model.addAttribute("admin", new Admin());
        model.addAttribute("fields", fieldService.getAllFields());
        return "admin";
    }

    @RequestMapping("/admin/getProfs")
    public String getAllProfessors(Model model) {
        ArrayList<Professor> list = (ArrayList<Professor>)profService.getAllProfs();
        model.addAttribute("professors", list);
        return "list-profs";
    }



    @RequestMapping("/admin/getApplicants")
    public String getAllApplicants(Model model) {
        ArrayList<Applicant> list = (ArrayList<Applicant>)applicantService.getAllApplicants();
        model.addAttribute("applicants", list);
        return "list-applicants";
    }

    @RequestMapping("/admin/getFieldRelationShips/")
    public String getFilteringViaFields(Model model, @RequestParam(value = "field", required = false) String field) throws RecordNotFoundException {

        if(field != null){
            Field field1 = fieldService.findById(field);
            ArrayList<Applicant> list = (ArrayList<Applicant>)applicantService.getApplicantByField(field1);
            model.addAttribute("applicants", list);
        }

        return "set-prof-applicant-relationship";
    }

    @RequestMapping("/admin/startRelationShip/{id}")
    public String getListOfProfs(Model model, @PathVariable(value = "id", required = false) long id) throws RecordNotFoundException {
        Applicant applicant = applicantService.getApplicantById(id);
        Field field1 = fieldService.findById(applicant.getResearch().getField());
        ArrayList<Professor> list = (ArrayList<Professor>)profService.getProfsByField(field1);
        model.addAttribute("applicant", applicant);
        model.addAttribute("profs", list);

        return "selectProf";
    }


    @RequestMapping(value = "/admin/settingRelation", method = RequestMethod.POST)
    public String setRelationships(Applicant applicant) throws RecordNotFoundException {

            if(applicant.getProfessorId() != null){
                long profId = Long.parseLong(applicant.getProfessorId());
                Professor prof = profService.getProfessorById(profId);
                applicant = applicantService.setProfessor(applicant, prof);
                profService.addApplicant(applicant, prof);
            }

        return "redirect:/admin/getFieldRelationShips/?field=" + applicant.getResearch().getField();
    }

    @RequestMapping(path = "/reviewApplicantsAdmin")
    public String reviewApplicants(Model model, @RequestParam(value = "id", required = false) String id) throws RecordNotFoundException {

        if(!id.isEmpty()) {
            Professor professor = profService.getProfessorById(Long.parseLong(id));
            List<Applicant> listApps = (ArrayList<Applicant>) applicantService.getApplicantsWithRecomendations(professor);
            System.out.println(listApps.size());
            model.addAttribute("applicants", listApps);
        }
        return "admin-applicant-desicion";
    }


    @RequestMapping(path = "/setFinalDecision", method = RequestMethod.POST)

    public String reviewApplicants(Model model, Applicant applicant) throws RecordNotFoundException {
        System.out.println(applicant);
        /*for (S dto: applicantProfRecomendationDTO.getList()) {
            Applicant applicant = applicantService.getApplicantById(Long.parseLong(dto.getApplicantid()));
            applicantService.setRecommendation(applicant, Integer.parseInt(dto.getProfRecomendationindex()));
        }*/

        return "redirect:/admin";
    }

}
