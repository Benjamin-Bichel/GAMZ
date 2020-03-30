package Application.DataModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends CrudRepository<Applicant, Integer> {
   public Applicant findByName(String name);
}
