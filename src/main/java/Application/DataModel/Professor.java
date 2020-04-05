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

    private String research;

    @Autowired
    public Professor(){
        super();
    }

    public Professor(String name, String email){
        super(name, email);
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

}
