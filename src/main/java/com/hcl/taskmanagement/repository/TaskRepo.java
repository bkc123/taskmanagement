package com.hcl.taskmanagement.repository;

import com.hcl.taskmanagement.model.Task;
import com.hcl.taskmanagement.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends CrudRepository<Task, Integer> {
	
	//@Query("select t from TASKS  t where user.id= 1")
	List <Task>findAllByUser(User user);

}
