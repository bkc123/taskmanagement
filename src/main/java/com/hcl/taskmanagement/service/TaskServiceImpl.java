package com.hcl.taskmanagement.service;


import com.hcl.taskmanagement.repository.TaskRepo;
import com.hcl.taskmanagement.model.Task;
import com.hcl.taskmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskRepo repo;
	@Override
	public Task saveOrUpdate(Task task) {
		
		return repo.save(task);
	}

	@Override
	public Optional<Task> findById(int taskid) {
		
		return repo.findById (taskid);
	}

	@Override
	public List<Task> getAllTasks() {
	return (List<Task>) repo.findAll();
	}

	@Override
	public List<Task> getAllTasksByUser(User user) {
		
		return repo.findAllByUser(user);
	}

	@Override
	public void deleteTask(Task task) {
		repo.delete(task);

	}

}
