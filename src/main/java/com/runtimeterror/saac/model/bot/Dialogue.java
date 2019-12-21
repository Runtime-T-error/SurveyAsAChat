package com.runtimeterror.saac.model.bot;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dialogue")
public class Dialogue {

    @Id
    @Column(name = "id", length = 255)
    private String id;

    @Column(name = "status", length = 255)
    private String status;

    @OneToOne
    private Survey survey;

    @OneToMany
    private List<Answer> answers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
