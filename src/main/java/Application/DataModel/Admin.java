package Application.DataModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;


@Entity
public class Admin extends User {
    private Role role;
    @OneToMany
    private List<Applicant> allApplicants;
    @OneToMany
    private List<Professor> allProfessors;
    public Admin (){
        super();
        this.role = Role.APPLICANT;
    }

    public void saveApplicant(Applicant applicant){
        allApplicants.add(applicant);
    }

    public void removeApplicant(Applicant applicant){
        allApplicants.remove(applicant);
    }

    public void saveProf(Professor professor){
        allProfessors.add(professor);
    }

    public void removeProf(Professor professor){
        allProfessors.remove(professor);
    }
}
