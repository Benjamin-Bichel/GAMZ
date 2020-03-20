package Application.DataModel;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Professor extends User {

    @Id
    private String name;
    @OneToOne
    private Faculty faculty;
    @OneToMany
    private List<Project> projectList;
    @OneToMany
    private List<Field> seekingFields;
    @ManyToMany
    private List<Field> activeFields;
    @ManyToMany
    private List<Applicant> applicants;
    private Role role;
    private boolean active;
    private String research;

    @Autowired
    public Professor() {
        super();
        this.applicants = new ArrayList<>();
        active = true;
        this.role = Role.PROF;
    }
    @Autowired
    public Professor(String name) {
        this.name = name;
    }

    @Autowired
    public Professor(String name, Faculty faculty) {
        super(name);
        this.faculty = faculty;
    }
    @Autowired
    public Professor(String name, Faculty faculty, String research) {
        super(name);
        this.faculty = faculty;
        this.research = research;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public boolean isActive() {
        return active;
    }

    public void setInactive(){
        this.active = false;
    }
}
