import javax.persistence.*;
import java.util.List;
@Table
@Entity
public class Professor extends User {

    @ManyToOne
    private Faculty faculty;
    //Multiple indexes
    @OneToMany
    private List<Project> activeProjectsList;
    @OneToMany
    private List<Feild> seekingFeilds;
    @OneToMany
    private List<Project> proposedProjects;
    @ManyToMany
    private List<Feild> activeFeilds;
    @ManyToMany
    private List<Feild> constantFeilds;



}
