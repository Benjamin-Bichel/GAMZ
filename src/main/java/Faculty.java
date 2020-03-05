import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table
@Entity
public class Faculty {
    @Id
    private int id;
    private String name;
    //dose this mean 2 indexes then
    private List<Professor> activeProfessors;
    private List<Professor> inactiveProfessors;

    @OneToMany
    private List<Professor> allProfessors;
}
