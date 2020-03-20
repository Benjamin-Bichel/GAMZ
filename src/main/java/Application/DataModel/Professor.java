package Application.DataModel;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Professor extends User {

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
    //private Role role;
    //private boolean active;
    private String name;
    private String research;

    @Autowired
    public Professor(){
        super();
    }

    public Professor(String name) {
        this.name = name;
    }

   /* public Professor(String name) {
       super(name);
        this.name = name;
        this.applicants = new ArrayList<>();
        active = true;
        this.role = Role.PROF;
    }

    public Professor(String name, Faculty faculty) {
        super(name);
        this.faculty = faculty;
        this.role = Role.PROF;
    }
    public Professor(String name, Faculty faculty, String research) {
        super(name);
        this.faculty = faculty;
        this.research = research;
        this.role = Role.PROF;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

}
