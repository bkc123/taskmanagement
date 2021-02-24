package com.hcl.taskmanagement.service;


import com.hcl.taskmanagement.model.Task;
import com.hcl.taskmanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {

	public Task saveOrUpdate(Task task);
	public Optional<Task> findById(int taskid);
	public List<Task> getAllTasks();
	public List<Task> getAllTasksByUser(User user);
	public void deleteTask(Task task);
	
}
