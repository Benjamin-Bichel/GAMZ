import java.awt.*;
import java.util.List;

import javax.persistence.*;

@Table
@Entity
public class Applicant extends User{



    private  String email;
    private String summary;
    private  String address;
    private List<Skills> skillsList;
    private Education education;
    private List<String> employmentHistory;
    private List<String> volenteerHistory;
    private String otherInformation;
    private boolean adminAproval;
    private ProfessorRecomendation recomendation;
    private boolean finalRecomendation;
    private Project project;
    private Image deploma;

}
