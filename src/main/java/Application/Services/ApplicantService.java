package Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Application.DataModel.*;

import java.util.List;


@Component
public class ApplicantService {

    private CVInterpeter interpeter = new CVInterpeter();

    @Autowired
    private ApplicantRepo repo;

    public void add(Applicant applicant){
        repo.save(applicant);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public List<Applicant> getApplicants(){
        return (List<Applicant>) repo.findAll();
    }
}
