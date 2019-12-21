package com.runtimeterror.saac.model.bot;

import com.runtimeterror.saac.model.def.AnswerOption;
import com.runtimeterror.saac.model.def.Question;
import com.runtimeterror.saac.model.def.User;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Survey survey;

    @ManyToOne
    private User withUser;

    @ManyToOne
    private Question question;

    @ManyToOne
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerOption getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerOption answer) {
        this.answer = answer;
    }
}
