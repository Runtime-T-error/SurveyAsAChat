package com.runtimeterror.saac.controllers;

public class SurveyDTO {
    private String userId;
    private String surveyId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
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
