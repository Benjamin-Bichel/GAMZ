package Application.DataModel;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professor extends User {

    @OneToMany
    private List<Applicant> applicants;
    @OneToOne
    private Field research;

    @Autowired
    public Professor(){
        super();
    }

    public Professor(String name, String email) {
        super(name, email);
    }

    public Field getResearch() {
        return research;
    }

    public void setResearch(Field research) {
        this.research = research;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
}
