package com.runtimeterror.saac.model.bot;

import com.runtimeterror.saac.model.def.Question;

import javax.persistence.*;

@Entity
@Table(name = "surveys_questions")
public class QuestionSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @Column(name = "order_number", nullable = false)
    private Integer order;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "QuestionSurvey{" +
                "id=" + id +
                ", question=" + question +
                ", survey=" + survey +
                ", order=" + order +
                '}';
    }
}
