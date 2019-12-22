package com.runtimeterror.saac.dto;

import java.util.List;

public class MessageResponse {
    private String recipientId;
    private List<String> response;
    private Long questionId;

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "recipientId=" + recipientId +
                ", response=" + response +
                ", questionId=" + questionId +
                '}';
    }
}
