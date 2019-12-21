package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.bot.Answer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswersDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Answer> getAllAnswersBySurveyId(Long userId, Long surveyId) {
        TypedQuery<Answer> query = em.createQuery("select a from Answer a where a.survey.id = :surveyId and a.withUser.id = :userId order by a.id desc", Answer.class);
        query.setParameter("surveyId", surveyId);
        return query.getResultStream().collect(Collectors.toList());
    }



}
