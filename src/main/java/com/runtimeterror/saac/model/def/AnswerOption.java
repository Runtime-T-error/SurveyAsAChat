package com.runtimeterror.saac.model.def;

import javax.persistence.*;

@Entity
@Table(name = "answer_options")
public class AnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_text", length = 1024, nullable = false)
    private String optionText;

    @Column(name = "precode")
    private Integer precode;

    @ManyToOne
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Integer getPrecode() {
        return precode;
    }

    public void setPrecode(Integer precode) {
        this.precode = precode;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "AnswerOption{" +
                "id=" + id +
                ", optionText='" + optionText + '\'' +
                ", precode=" + precode +
                ", question=" + question +
                '}';
    }
}
