package Application.DataModel;

import javax.persistence.*;
import java.util.List;

@Table
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
    private List<String> volenteerHistory;
    private String otherInformation;
    private boolean adminAproval;
    private ProfessorRecomendation recomendation;
    private boolean finalRecomendation;
    @ManyToOne
    private Project project;

    private byte[] deploma;

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

    public boolean isAdminAproval() {
        return adminAproval;
    }

    public void setAdminAproval(boolean adminAproval) {
        this.adminAproval = adminAproval;
    }

    public boolean isFinalRecomendation() {
        return finalRecomendation;
    }

    public void setFinalRecomendation(boolean finalRecomendation) {
        this.finalRecomendation = finalRecomendation;
    }

    public ProfessorRecomendation getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(ProfessorRecomendation recomendation) {
        this.recomendation = recomendation;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public byte[] getDeploma() {
        return deploma;
    }

    public void setDeploma(byte[] deploma) {
        this.deploma = deploma;
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

    public List<String> getVolenteerHistory() {
        return volenteerHistory;
    }

    public void setVolenteerHistory(List<String> volenteerHistory) {
        this.volenteerHistory = volenteerHistory;
    }
}
