package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.bot.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswersRepository extends CrudRepository<Answer, Long> {
}
