package Application.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import Application.DataModel.ProfRepo;
import Application.DataModel.Professor;
import Application.Exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfService {

    @Autowired
    ProfRepo repository;

    public List<Professor> getAllProfs()
    {
        List<Professor> result = (List<Professor>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Professor>();
        }
    }

    public Professor getProfessorById(Long id) throws RecordNotFoundException
    {
        Optional<Professor> professor = repository.findById(id);

        if(professor.isPresent()) {
            return professor.get();
        } else {
            throw new RecordNotFoundException("No professor record exist for given id");
        }
    }

    public Professor createOrUpdateProf(Professor professor)
    {
        if(professor.getId()  == null)
        {
            professor = repository.save(professor);

            return professor;
        }
        else
        {
            Optional<Professor> prof = repository.findById(professor.getId());

            if(prof.isPresent())
            {
                Professor newEntity = prof.get();
                newEntity.setName(professor.getName());
                newEntity.setEmail(professor.getEmail());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                professor = repository.save(professor);

                return professor;
            }
        }
    }

    public void deleteProfessorById(Long id) throws RecordNotFoundException
    {
        Optional<Professor> professor = repository.findById(id);

        if(professor.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No professor record exist for given id");
        }
    }
}