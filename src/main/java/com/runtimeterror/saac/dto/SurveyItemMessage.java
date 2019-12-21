package com.runtimeterror.saac.dto;

import java.util.List;
import java.util.UUID;

public class SurveyItemMessage {

    private ReceiverDTO receiver;
    private String question;
    private List<String> responses;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    public ReceiverDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(ReceiverDTO receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "SurveyItemMessage{" +
                "receiver=" + receiver +
                ", question='" + question + '\'' +
                ", responses=" + responses +
                '}';
    }
}
