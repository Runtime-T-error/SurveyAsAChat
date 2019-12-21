package com.runtimeterror.saac.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @Column(name = "id")
    private String id;

    @OneToMany
    private List<Question> questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
