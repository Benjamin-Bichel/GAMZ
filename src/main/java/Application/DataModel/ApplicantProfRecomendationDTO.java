package Application.DataModel;

import java.util.List;

public class ApplicantProfRecomendationDTO {
    private String applicantid;
    private String profRecomendationindex;
    private List<ApplicantProfRecomendationDTO> list;

    public String getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(String applicantid) {
        this.applicantid = applicantid;
    }

    public String getProfRecomendationindex() {
        return profRecomendationindex;
    }

    public void setProfRecomendationindex(String profRecomendationindex) {
        this.profRecomendationindex = profRecomendationindex;
    }

    public List<ApplicantProfRecomendationDTO> getList() {
        return list;
    }

    public void setList(List<ApplicantProfRecomendationDTO> list) {
        this.list = list;
    }
}
