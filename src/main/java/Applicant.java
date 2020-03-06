import java.awt.*;
import java.util.List;

import javax.persistence.*;

@Table
@Entity
public class Applicant extends User{



    private  String email;
    private String summary;
    private  String address;
    @OneToMany
    private List<Skills> skillsList;
    @OneToOne
    private Education education;
    @ElementCollection
    private List<String> employmentHistory;
    @ElementCollection
    private List<String> volenteerHistory;
    private String otherInformation;
    private boolean adminAproval;
    private ProfessorRecomendation recomendation;
    private boolean finalRecomendation;
    @ManyToOne
    private Project project;

    private byte[] deploma;

}
