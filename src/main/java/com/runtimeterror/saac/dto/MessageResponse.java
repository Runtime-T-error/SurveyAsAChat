package com.runtimeterror.saac.dto;

import java.util.List;

public class MessageResponse {
    private String recipientId;
    private List<String> response;

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

    @Override
    public String toString() {
        return "MessageResponse{" +
                "recipientId=" + recipientId +
                ", response=" + response +
                '}';
    }
}
