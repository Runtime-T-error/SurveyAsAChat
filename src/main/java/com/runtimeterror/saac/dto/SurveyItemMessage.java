package com.runtimeterror.saac.dto;

import java.util.List;
import java.util.UUID;

public class SurveyItemMessage {

    private ReceiverDTO receiver;
    private UUID sequenceId;
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

    public UUID getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(UUID sequenceId) {
        this.sequenceId = sequenceId;
    }

    public boolean containsResponse(String response) {
        for(String resp : responses)
            if(resp.equals(response))
                return true;
        return false;
    }
}
