package com.runtimeterror.saac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    private String id;
    @Column(name = "survey_id", length = 255)
    private String surveyId;
    @Column(name = "user_id", length = 255)
    private String userId;
    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "answer_id")
    private Long answerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "SurveyResponse{" +
                "id='" + id + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", userId='" + userId + '\'' +
                ", questionId=" + questionId +
                ", answerId=" + answerId +
                '}';
    }
}
