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

    @Autowired
    ApplicantService service;




}
