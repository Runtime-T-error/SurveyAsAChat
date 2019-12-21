package com.runtimeterror.saac.dto;

import java.util.UUID;

public class MessageResponse {
    private UUID sequenceId;
    private String response;

    public UUID getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(UUID sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
