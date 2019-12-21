package com.runtimeterror.saac.controllers;

public class SurveyDTO {
    private Long userId;
    private Long surveyId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "userId='" + userId + '\'' +
                ", surveyId='" + surveyId + '\'' +
                '}';
    }
}
