package com.budget.wiz.skip.app.repository;


import com.budget.wiz.skip.app.domain.object.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{

    Optional<User> findByUserName(String userName);

}
