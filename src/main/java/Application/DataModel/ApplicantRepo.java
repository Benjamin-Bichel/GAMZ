package Application.DataModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends CrudRepository<Applicant, Integer> {

    Applicant findById(int id);
}