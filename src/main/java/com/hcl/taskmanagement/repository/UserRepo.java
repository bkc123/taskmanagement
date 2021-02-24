package com.hcl.taskmanagement.repository;

import com.hcl.taskmanagement.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
	Optional<User> findByUsername(String username);

}
