package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.bot.QuestionSurvey;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Component
public class QuestionSurveyDAO {

    @PersistenceContext
    private EntityManager em;

    public Optional<QuestionSurvey> getNextQuestion(Long surveyId, Integer order) {
        TypedQuery<QuestionSurvey> questionTypedQuery = em.createQuery("select qs from QuestionSurvey qs where qs.survey.id = :surveyId and qs.order = :order", QuestionSurvey.class);
        questionTypedQuery.setParameter("surveyId", surveyId);
        questionTypedQuery.setParameter("order", order);
        return questionTypedQuery.getResultStream().findFirst();
    }

}
