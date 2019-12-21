package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.def.Question;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Component
public class SurveyDAO {

    @PersistenceContext
    private EntityManager em;

    public Optional<Question> getNextQuestion(Long surveyId, Long minId) {
        return Optional.empty();
    }

}
