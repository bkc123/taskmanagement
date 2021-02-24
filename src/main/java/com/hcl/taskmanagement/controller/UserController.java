package com.hcl.taskmanagement.controller;


import com.hcl.taskmanagement.model.Task;
import com.hcl.taskmanagement.model.User;
import com.hcl.taskmanagement.repository.UserRepo;
import com.hcl.taskmanagement.service.TaskServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	TaskServiceImpl service;
	@Autowired
	UserRepo repo;

	static User user;

	@GetMapping("/")
	public String login() {
		return "login";

	}

	@GetMapping("/register")
	public String registration() {

		return "register";
	}

	@PostMapping("/register")
	public String admin(@RequestParam(name = "username") String username,
						@RequestParam(name = "role") String role,
						@RequestParam(name = "password") String password,
						@RequestParam(name = "email") String email,
						@RequestParam(name = "firstname") String firstname,
						@RequestParam(name = "lastname") String lastname) {

		user = new User();
		user.setUsername(username);
		user.setRole(role);
		user.setPwd(password);
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		repo.save(user);
		return "login";
	}


	@RequestMapping("/welcome")
	public String welcome(ModelMap model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();

			user = repo.findByUsername(currentUserName).get();
		}
		model.put("msg", "Hello " + user.getUsername());
		return "welcome";
	}

	@GetMapping("/create")
	public String create(ModelMap model) {
		model.put("userid", user.getUserid());
		return "create";
	}

	@PostMapping("/create")
	public String createTask(@ModelAttribute("task") Task task,
		 ModelMap model) {
		task.setUser(user);
		service.saveOrUpdate(task);
		System.out.println(task.toString());
		model.put("tasks", service.getAllTasksByUser(user));
		return "display";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam(name = "selected") String id, ModelMap model) {
		System.out.println(id);
		model.put("task", service.findById(Integer.parseInt(id)).get());
		return "delete";
	}

	@PostMapping("/deleteUpdate")
	public String deleteUpdate(@RequestParam(name = "task.id") String id, ModelMap model) {
		System.out.println(service.findById(Integer.parseInt(id)).get());
		service.deleteTask(service.findById(Integer.parseInt(id)).get());
		model.put("msg", "Task has been deleted successfully");
		return "welcome";
	}

	@GetMapping("/display")
	public String display(ModelMap model) {
		if (!service.getAllTasksByUser(user).isEmpty()) {

			model.put("tasks", service.getAllTasksByUser(user));
		} else {
			model.put("msg", "No tasks created");
		}

		return "display";
	}

	@GetMapping("/updateFromWelcome")
	public String updateFromWelcome(ModelMap model) {
		model.put("msg", "pick a task to update");
		model.put("tasks", service.getAllTasksByUser(user));
		return "display";
	}

	@PostMapping("/update")
	public String update(@RequestParam(name = "selected") String id, ModelMap model, Task task) {
		System.out.println(id);
		model.put("task", service.findById(Integer.parseInt(id)).get());
		return "update";
	}

	@PostMapping("/updateConform")
	public String updateConform(@ModelAttribute("task") Task task, ModelMap model) {
		task.setUser(user);
		System.out.println(task.toString());
		model.put("msg", "task was updated successfully");
		service.saveOrUpdate(task);
		model.put("tasks", service.getAllTasksByUser(user));
		return "display";

	}
}
