package Application.DataModel;

import javax.persistence.*;
import java.util.List;


@Entity
public class Applicant extends User  {
    private  String address;
    private String research;
    private double CGPA;
    private String program;
    @OneToMany
    private List<Skills> skillsList;
    @OneToOne
    private Education education;
    @ElementCollection
    private List<String> employmentHistory;
    @ElementCollection
    private List<String> volunteerHistory;
    private String otherInformation;
    private boolean adminApproval;
    private ProfessorRecommendation recommendation;
    private boolean finalRecommendation;
    @ManyToOne
    private Project project;
    private byte[] diploma;

public Applicant(){}
    public Applicant(String name, String email){
        super(name, email);
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program ) {
        this.program = program;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public boolean isAdminApproval() {
        return adminApproval;
    }

    public void setAdminApproval(boolean adminApproval) {
        this.adminApproval = adminApproval;
    }

    public boolean isFinalRecommendation() {
        return finalRecommendation;
    }

    public void setFinalRecommendation(boolean finalRecommendation) {
        this.finalRecommendation = finalRecommendation;
    }

    public ProfessorRecommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(ProfessorRecommendation recommendation) {
        this.recommendation = recommendation;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public byte[] getDiploma() {
        return diploma;
    }

    public void setDiploma(byte[] diploma) {
        this.diploma = diploma;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<String> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<String> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public List<String> getVolunteerHistory() {
        return volunteerHistory;
    }

    public void setVolunteerHistory(List<String> volunteerHistory) {
        this.volunteerHistory = volunteerHistory;
    }


}
