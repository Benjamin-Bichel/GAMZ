package Application.DataModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepo extends CrudRepository<Professor, Integer> {

}
