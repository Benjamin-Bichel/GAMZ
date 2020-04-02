package Application.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Application.DataModel.Applicant;
import Application.DataModel.ApplicantRepo;
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

    public Applicant createOrUpdateApplicant(Applicant applicant)
    {
        if(applicant.getId()  == null)
        {
            applicant = repository.save(applicant);

            return applicant;
        }
        else
        {
            Optional<Applicant> employee = repository.findById(applicant.getId());

            if(employee.isPresent())
            {
                Applicant newEntity = employee.get();
                newEntity.setName(applicant.getName());
                newEntity.setEmail(applicant.getEmail());
                newEntity.setAddress(applicant.getAddress());

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
}