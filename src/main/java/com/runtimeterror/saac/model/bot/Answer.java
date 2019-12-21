package com.runtimeterror.saac.model.bot;

import com.runtimeterror.saac.model.def.User;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User withUser;

    @Column(name = "answer", length = 2048, nullable = false)
    private String answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public User getWithUser() {
        return withUser;
    }

    public void setWithUser(User withUser) {
        this.withUser = withUser;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", survey=" + survey +
                ", withUser=" + withUser +
                ", answers=" + answers +
                '}';
    }
}
