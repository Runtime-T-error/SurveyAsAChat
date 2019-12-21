package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.bot.Dialogue;
import org.springframework.data.repository.CrudRepository;

public interface DialogueRepository extends CrudRepository<Dialogue, Long> {
}
