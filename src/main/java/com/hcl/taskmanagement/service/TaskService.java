package com.hcl.taskmanagement.service;

import com.hcl.taskmanagement.model.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findTaskByUsername(String username);

    Optional<Task> findTaskById(Integer id);

    public void updateTask(Task task);

    public void addTask(String username, String Desc, Date startDate, Date endDate, boolean status);

    public void deleteTaskById(Integer id);

    public void saveTask(Task task);


}
