package com.runtimeterror.saac.model.bot;

import javax.persistence.*;

@Entity
@Table(name = "dialogue_template")
public class DialogueTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "text", length = 1024, nullable = false)
    private String text;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "template_type", length = 16, nullable = false)
    private String templateType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "DialogueTemplate{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", gender='" + gender + '\'' +
                ", templateType='" + templateType + '\'' +
                '}';
    }
}
