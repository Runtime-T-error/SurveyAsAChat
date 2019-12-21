package com.runtimeterror.saac.dto;

public class ReceiverDTO {
    public long id;
    //public String name

    public ReceiverDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
