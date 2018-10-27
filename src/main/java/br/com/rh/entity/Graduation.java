package br.com.rh.entity;

import br.com.rh.enums.GraduationSituation;
import br.com.rh.enums.GraduationType;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Graduation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private GraduationType type;
    private String name;
    private String institution;
    private String courseClassification;
    private GraduationSituation situation;
    private Integer completionYear;
    private Integer completionMonth;

    public Graduation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GraduationType getType() {
        return type;
    }

    public void setType(GraduationType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCourseClassification() {
        return courseClassification;
    }

    public void setCourseClassification(String courseClassification) {
        this.courseClassification = courseClassification;
    }

    public GraduationSituation getSituation() {
        return situation;
    }

    public void setSituation(GraduationSituation situation) {
        this.situation = situation;
    }

    public Integer getCompletionYear() {
        return completionYear;
    }

    public void setCompletionYear(Integer completionYear) {
        this.completionYear = completionYear;
    }

    public Integer getCompletionMonth() {
        return completionMonth;
    }

    public void setCompletionMonth(Integer completionMonth) {
        this.completionMonth = completionMonth;
    }
}
