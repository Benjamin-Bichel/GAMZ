package Application.DataModel;

import org.springframework.data.repository.CrudRepository;

public interface ProfRepo extends CrudRepository<Professor, Long> {
    Iterable<Professor> findAllByResearch(Field field);
}
