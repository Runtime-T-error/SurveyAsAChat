package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.def.Question;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Component
public class QuestionDAO {

    @PersistenceContext
    private EntityManager em;

    public Optional<Question> getNextQuestion(Long surveyId, Long minId) {
//        TypedQuery<Question> query = em.createQuery("select q from Question q where q.id");
        return Optional.empty();
    }

}
