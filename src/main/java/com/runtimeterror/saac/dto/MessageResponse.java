package com.runtimeterror.saac.dto;

import java.util.List;

public class MessageResponse {
    private Long dialogueId;
    private List<String> response;
    private Long questionId;

    public Long getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(Long dialogueId) {
        this.dialogueId = dialogueId;
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
                "dialogueId=" + dialogueId +
                ", response=" + response +
                ", questionId=" + questionId +
                '}';
    }
}
