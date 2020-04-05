package Application.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Application.App;
import Application.DataModel.Applicant;
import Application.DataModel.ApplicantRepo;
import Application.DataModel.Field;
import Application.DataModel.Professor;
import Application.Exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    @Autowired
    ApplicantRepo repository;

    public List<Applicant> getAllApplicants()
    {
        List<Applicant> result = (List<Applicant>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Applicant>();
        }
    }

    public Applicant getApplicantById(Long id) throws RecordNotFoundException
    {
        Optional<Applicant> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No applicant record exist for given id");
        }
    }

    public Applicant setProfessor(Applicant applicant, Professor professor) throws RecordNotFoundException {
        Optional<Applicant> applicantx = repository.findById(applicant.getId());

        if(applicantx.isPresent())
        {
            Applicant applicantx1 = applicantx.get();
            applicantx1.setProfessorProposed(professor);
            repository.save(applicantx1);
            return  applicantx1;
        } else {
            throw new RecordNotFoundException("No professor record exist for given id");
        }
    }

    public Applicant setRecommendation(Applicant applicant, int recommendationvalue) throws RecordNotFoundException {
        Optional<Applicant> applicantx = repository.findById(applicant.getId());

        if(applicantx.isPresent())
        {
            Applicant applicantx1 = applicantx.get();
            applicantx1.setRecommendation("" + recommendationvalue);
            repository.save(applicantx1);
            return  applicantx1;
        } else {
            throw new RecordNotFoundException("No professor record exist for given id");
        }
    }

    public Applicant createOrUpdateApplicant(Applicant applicant)
    {
        if(applicant.getId()  == null)
        {
            applicant = repository.save(applicant);

            return applicant;
        }
        else
        {
            Optional<Applicant> user = repository.findById(applicant.getId());

            if(user.isPresent())
            {
                Applicant newEntity = user.get();
                newEntity.setName(applicant.getName());
                newEntity.setEmail(applicant.getEmail());
                newEntity.setAddress(applicant.getAddress());
                newEntity.setResearch(applicant.getResearch());
                newEntity.setProgram(applicant.getProgram());
                newEntity.setProfessorProposed(applicant.getProfessorProposed());
                newEntity.setCGPA(applicant.getCGPA());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                applicant = repository.save(applicant);

                return applicant;
            }
        }
    }

    public void deleteApplicantById(Long id) throws RecordNotFoundException
    {
        Optional<Applicant> applicant = repository.findById(id);

        if(applicant.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No applicant record exist for given id");
        }
    }





    public List<Applicant> getApplicantByField(Field field){
        ArrayList<Applicant> applicantsWithoutProfs = new ArrayList<Applicant>();
        List<Applicant> result = (List<Applicant>) repository.findAllByResearch(field);

        if(result.size() > 0) {
            for ( Applicant app: result) {
                if(app.getProfessorProposed() == null){
                    applicantsWithoutProfs.add(app);
                }
            }
        }
        return applicantsWithoutProfs;
    }

    public List<Applicant> getApplicantsByProfessor(Professor professor){
        ArrayList<Applicant> applicantsWithoutRecommendations = new ArrayList<Applicant>();
        List<Applicant> result = (List<Applicant>) repository.findAll();

        if(result.size() > 0){
            for (Applicant app: result) {
                if(app.getRecommendation() == null){


                        applicantsWithoutRecommendations.add(app);

                }else if(app.getRecommendation().isEmpty()){
                    applicantsWithoutRecommendations.add(app);
                }
            }
        }
        return applicantsWithoutRecommendations;
    }

    public List<Applicant> getApplicantsWithRecomendations(Professor professor){
        ArrayList<Applicant> applicantsWithRecommendations = new ArrayList<Applicant>();
        List<Applicant> result = (List<Applicant>) repository.findAll();

        if(result.size() > 0){
            for (Applicant app: result) {
                if(app.getRecommendation() != null){
                    if(!app.getRecommendation().isEmpty() ){
                        applicantsWithRecommendations.add(app);
                    }



                }
            }
        }
        return applicantsWithRecommendations;
    }


}