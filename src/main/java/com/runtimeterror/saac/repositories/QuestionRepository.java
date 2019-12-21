package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
