package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.bot.Dialogue;
import com.runtimeterror.saac.model.bot.DialogueTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class DialogueTemplateDAO {

    private static final String DEFAULT_OPENER = "Hi, would you like to take a survey?";
    private static final String DEFAULT_END = "Thanks for your time! See you around!";

    @PersistenceContext
    private EntityManager em;

    public String resolveOpener(String gender, Integer age) {
        String query = "select dt from DialogueTemplate dt ";
        List<String> wherePart = new ArrayList<>();
        if (!StringUtils.isEmpty(gender)) {
            wherePart.add("(dt.gender is null or dt.gender = :gender)");
        }
        if (age != null) {
            wherePart.add("(dt.minAge is null or dt.minAge <= :age)");
            wherePart.add("(dt.maxAge is null or dt.maxAge >= :age)");
        }

        String where = wherePart.isEmpty() ? "" : "where " + String.join( " and ", wherePart);

        TypedQuery<DialogueTemplate> typedQuery = em.createQuery(query + where, DialogueTemplate.class);

        if (!StringUtils.isEmpty(gender)) {
            typedQuery.setParameter("gender", gender);
        }
        if (age != null) {
            typedQuery.setParameter("age", age);

        }

        List<DialogueTemplate> openers = typedQuery.getResultList();
        if (openers.isEmpty()){
            return DEFAULT_OPENER;
        }
        Random rnd = new Random();
        return openers.get(rnd.nextInt(openers.size())).getText();
    }

    public String resolveEndMessage(String gender, Integer age) {
        return DEFAULT_END;
    }
}
