package com.runtimeterror.saac.model;

import com.runtimeterror.saac.dto.SurveyItemMessage;

import java.util.List;
import java.util.UUID;

public class Sequence {
    private UUID id;
    private List<SurveyItemMessage> items;
    private int position;

    public Sequence(UUID id, List<SurveyItemMessage> items) {
        this.id = id;
        this.items = items;
        position = 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<SurveyItemMessage> getItems() {
        return items;
    }

    public void setItems(List<SurveyItemMessage> items) {
        this.items = items;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public SurveyItemMessage getCurrentItem() {
        if(position >= items.size()) return null;
        return items.get(position);
    }

    public boolean advancePosition() {
        position++;
        return position < items.size();
    }
}
