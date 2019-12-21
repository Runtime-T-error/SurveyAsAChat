package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.bot.Dialogue;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Component
public class DialogueDAO {

    @PersistenceContext
    private EntityManager em;

    public Optional<Dialogue> getActiveDialogue(Long userId) {
        TypedQuery<Dialogue> query = em.createQuery("select d from Dialogue d where d.user.id = :userId and d.finished = false" , Dialogue.class);
        query.setParameter("userId", userId);
        return query.getResultStream().findFirst();
    }
}
