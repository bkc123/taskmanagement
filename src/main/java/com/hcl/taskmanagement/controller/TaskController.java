package com.hcl.taskmanagement.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hcl.taskmanagement.model.Task;
import com.hcl.taskmanagement.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    @RequestMapping(value = "/tasklist", method = RequestMethod.GET)
    public String showTask(ModelMap model){
        String name = getLoggedInUserName(model);
        model.put("task", taskService.findTaskByUsername(name));
        return "tasklist";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.GET)
    public String showAddTaskPage(ModelMap model) {
        model.addAttribute("task", new Task());
        return "task";
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
    public String deleteTask(@RequestParam Integer id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasklist";
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.GET)
    public String showUpdatedTaskPage(@RequestParam Integer id, ModelMap model) {
        Task task = taskService.findTaskById(id).get();
        model.put("task", task);
        return "task";
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public String updateTask(ModelMap model, @Valid Task task, BindingResult result) {

        if (result.hasErrors()) {
            return "task";
        }

        task.setUsername(getLoggedInUserName(model));
        taskService.updateTask(task);
        return "redirect:/tasklist";
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addTask(ModelMap model, @Valid Task task, BindingResult result) {

        if (result.hasErrors()) {
            return "task";
        }

        task.setUsername(getLoggedInUserName(model));
        taskService.saveTask(task);
        return "redirect:/tasklist";
    }
}
