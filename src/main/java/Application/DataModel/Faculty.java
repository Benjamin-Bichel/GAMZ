package Application.DataModel;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Faculty {
    @Id
    @GeneratedValue()
    private int id;
    private String name;
    //dose this mean 2 indexes then

    @OneToMany
    private List<Professor> allProfessors;
}
