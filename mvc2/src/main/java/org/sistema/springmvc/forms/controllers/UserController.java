package org.sistema.springmvc.forms.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sistema.springmvc.forms.dao.TaskDAO;
import org.sistema.springmvc.forms.dao.UserDAO;
import org.sistema.springmvc.forms.entities.Task;
import org.sistema.springmvc.forms.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private TaskDAO taskDAO;

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/users" })
	public String showUsers(Map<String, Object> model) {
		logger.info("Product showUsers. ");

		List<User> users = (List<User>) userDAO.selectAll();
		model.put("users", users);

		return "user/users";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/users/{id}" })
	public String userDetail(@PathVariable(value = "id") Integer id, Model model) {

		logger.info("User detail");

		Map<String, Object> attrs = new HashMap<String, Object>();

		User user = userDAO.select(id);

		attrs.put("user", user);

		Task newTask = new Task();

		newTask.setUser(user);

		attrs.put("newTask", newTask);

		attrs.put("allTasks", taskDAO.selectAll());

		model.addAllAttributes(attrs);
		
		return "user/userDetail";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/users/new" })
	public String newUser(Map<String, Object> model) {
		logger.info("Showing custom view to insert by GET");

		model.put("user", new User());

		return "user/newUser";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/new")
	public ModelAndView createUser(User user, Map<String, Object> model) {

		logger.info("Saveview POST " + user.getId());

		ModelAndView modelAndView = new ModelAndView();

		if (userDAO.create(user) > 0) {
			modelAndView.setViewName("user/userCreated");
			modelAndView.addObject("user", user);

		} else {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error occurred while trying to create a new user. Please, try again");
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/users/update/{id}" })
	public String updateUser(@PathVariable(value = "id") Integer id, Model model) {
		model.addAttribute("user", userDAO.select(id));
		return "user/updateUser";
	}

	@RequestMapping(method = RequestMethod.POST, value = { "/users/saveupdate" })
	public ModelAndView saveUpdate(User user) {
		logger.info("Save update " + user.getId());

		userDAO.update(user.getId(), user);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("user", user);
		modelAndView.setViewName("user/saveUpdated");

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/users/delete/{id}" })
	public String deleteUser(@PathVariable(value = "id") Integer id, Model model) {

		logger.info("Product detail / delete");
		userDAO.delete(id);
		model.addAttribute("userId", id);

		return "user/deleteUser";
	}

}
