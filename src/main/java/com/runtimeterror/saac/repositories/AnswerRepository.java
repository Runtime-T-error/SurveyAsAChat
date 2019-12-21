package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.AnswerOption;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<AnswerOption, Long> {
}
