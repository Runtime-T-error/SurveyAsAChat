package com.runtimeterror.saac.model.bot;

import com.runtimeterror.saac.model.def.User;

import javax.persistence.*;

@Entity
@Table(name = "dialogue")
public class Dialogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "finished", nullable = false)
    private Boolean finished;

    @Column(name = "last_question", nullable = false)
    private Integer lastQuestion;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getLastQuestion() {
        return lastQuestion;
    }

    public void setLastQuestion(Integer lastQuestion) {
        this.lastQuestion = lastQuestion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }


    @Override
    public String toString() {
        return "Dialogue{" +
                "id=" + id +
                ", finished=" + finished +
                ", lastQuestion=" + lastQuestion +
                ", survey=" + survey +
                ", user=" + user +
                '}';
    }
}
