package Application.DataModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table
@Entity
public class Project {
    @Id
    private int id;
    @OneToMany
    private List<Applicant> approvedStudents;
    private String projectDescription;
    @OneToMany
    private List<Field> projectsFeildsOfApplication;
    @OneToMany
    private List<Field> projectFeildsRequired;

    private boolean activeProject;
    private boolean approval;


}
