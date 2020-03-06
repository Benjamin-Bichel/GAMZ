import javax.persistence.*;
import java.util.List;
@Table
@Entity
public class Professor extends User {

    @ManyToOne
    private Faculty faculty;
    //Multiple indexes
    @OneToMany
    private List<Project> projectListrojectsList;
    @OneToMany
    private List<Feild> seekingFeilds;
    @ManyToMany
    private List<Feild> activeFeilds;

    private boolean active;
}
