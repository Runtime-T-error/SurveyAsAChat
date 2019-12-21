package com.runtimeterror.saac.model.bot;

import com.runtimeterror.saac.model.def.AnswerOption;
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

    @ManyToOne
    @JoinColumn(name = "answered_option_id")
    private AnswerOption answer;

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

    public AnswerOption getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerOption answer) {
        this.answer = answer;
    }
}
