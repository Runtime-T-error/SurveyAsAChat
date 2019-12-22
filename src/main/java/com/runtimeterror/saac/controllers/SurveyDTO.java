package com.runtimeterror.saac.controllers;

import com.runtimeterror.saac.service.provider.Provider;

public class SurveyDTO {
    private Long userId;
    private Long surveyId;
    private Provider provider;

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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "userId='" + userId + '\'' +
                ", surveyId='" + surveyId + '\'' +
                '}';
    }
}
