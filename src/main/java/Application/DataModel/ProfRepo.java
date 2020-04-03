package Application.DataModel;

import org.springframework.data.repository.CrudRepository;

public interface ProfRepo extends CrudRepository<Professor, Long> {

    Professor findByEmail(String email);
}
