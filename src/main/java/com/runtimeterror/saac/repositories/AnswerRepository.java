package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.def.AnswerOption;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<AnswerOption, Long> {
}
