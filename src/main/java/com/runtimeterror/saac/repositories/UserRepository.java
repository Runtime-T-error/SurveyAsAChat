package com.runtimeterror.saac.repositories;

import com.runtimeterror.saac.model.def.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
