package com.runtimeterror.saac.model;

import javax.persistence.*;

@Entity
@Table(name = "answer_options")
public class AnswerOption {
    @Id
    private long id;
    private String optionText;
    private int precode;
    @ManyToOne
    private Question question;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public int getPrecode() {
        return precode;
    }

    public void setPrecode(int precode) {
        this.precode = precode;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
