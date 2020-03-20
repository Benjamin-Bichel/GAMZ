package Application.DataModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Faculty {
    @Id
    @GeneratedValue()
    private int id;
    private String facultyName;

    @OneToMany
    private List<Professor> allProfessors;

    public Faculty(){

    }
    public Faculty(String facultyName){
        this.allProfessors = new ArrayList<>();
    }

    public void setFacultyName(String facultyName){
        this.facultyName = facultyName;
    }

    public String getFacultyName(){
        return facultyName;
    }

    public List<Professor> getAllProfessors(){
        return allProfessors;
    }

}
