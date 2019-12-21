package com.runtimeterror.saac.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Question {
    @Id
    private long id;
    private String name;
    private String questionText;
    private String questionType;
    @OneToMany
    private List<AnswerOption> answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<AnswerOption> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerOption> answers) {
        this.answers = answers;
    }
}
