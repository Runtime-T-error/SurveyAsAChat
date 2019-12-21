package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.bot.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
}
