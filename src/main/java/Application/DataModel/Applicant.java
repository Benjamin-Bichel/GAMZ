package Application.DataModel;

import javax.persistence.*;
import java.util.List;


@Entity
public class Applicant extends User {
    //Make a DTO later
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
    private List<String> volunteerHistory;
    private String otherInformation;
    private boolean adminApproval;
    private ProfessorRecommendation recommendation;
    private boolean finalRecommendation;
    @ManyToOne
    private Project project;
    private byte[] diploma;
    private Role role;
    private String name;

    public Applicant(){
        super();
        this.role = Role.APPLICANT;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
