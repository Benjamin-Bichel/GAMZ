package Application.DataModel;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Professor extends User {

    @ManyToOne
    private Faculty faculty;
    //Multiple indexes
    @OneToMany
    private List<Project> projectList;
    @OneToMany
    private List<Field> seekingFields;
    @ManyToMany
    private List<Field> activeFields;

    private boolean active;
    private String research;

    public Professor() {
        super();
    }

    public Professor(String name) {
        super(name);
    }

    public Professor(String name, String research) {
        super(name);
        this.research = research;

    }
    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }



}
