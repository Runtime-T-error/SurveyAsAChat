package com.runtimeterror.saac.dto;

public class ReceiverDTO {
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReceiverDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
