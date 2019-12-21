package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.def.AnswerOption;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswersOptionDAO {

    @PersistenceContext
    private EntityManager em;

    public List<AnswerOption> getOptionsForQuestion(Long questionId) {
        TypedQuery<AnswerOption> answerOptionTypedQuery = em.createQuery("select ao from AnswerOption ao where ao.question.id = :questionId", AnswerOption.class);
        answerOptionTypedQuery.setParameter("questionId", questionId);
        return answerOptionTypedQuery.getResultStream().collect(Collectors.toList());
    }

}
