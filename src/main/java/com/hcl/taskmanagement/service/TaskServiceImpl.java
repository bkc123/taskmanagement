package com.hcl.taskmanagement.service;

import com.hcl.taskmanagement.model.Task;
import com.hcl.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;
    @Override
    public List<Task> findTaskByUsername(String username) {
        return taskRepository.findByUsername(username);
    }

    @Override
    public Optional<Task> findTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);

    }

    @Override
    public void addTask(String username, String Desc, Date startDate, Date endDate, boolean status) {
        taskRepository.save(new Task(username, Desc, startDate, endDate, status));

    }


    @Override
    public void deleteTaskById(Integer id){
        taskRepository.deleteById(id);
        }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);

    }
}
