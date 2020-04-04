package Application.DataModel;

import Application.App;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends CrudRepository<Applicant, Long> {

    Iterable<Applicant> findAllByResearch(Field field);
}

