package org.sistema.springmvc.forms.controllers;

import org.sistema.springmvc.forms.dao.TaskDAO;
import org.sistema.springmvc.forms.entities.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tasks" )
public class TaskController {
	private static Logger logger = LoggerFactory.getLogger(Task.class);
	private TaskDAO dao;

	public TaskController(TaskDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/{id}" })
	public String showTaskDetail(@PathVariable(value = "id") Integer id, Model model) {
		logger.info("[GET] Showing task " + id + " detail");
		model.addAttribute("task", dao.select(id));

		return "task/taskDetail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public String createTask(@ModelAttribute("task") Task newTask, Model model) {
	    if (newTask.getUser() == null || newTask.getUser().getId() == null) {
	        logger.warn("[POST] Task creation failed: User is null or has no ID.");
	        model.addAttribute("message", "User is required to create a task.");
	        return "error";
	    }

	    logger.info("[POST] Trying to create a new task for user " + newTask.getUser().getId());
	    String view;
	    if (dao.create(newTask) >= 0) {
	        logger.info("[POST] New task has been created");
	        view = "task/created";
	        model.addAttribute(newTask);
	    } else {
	        view = "error";
	        model.addAttribute("message", "An error occurred while trying to create a new task.");
	        logger.warn("[POST] An error occurred while trying to create a new task");
	    }
	    return view;
	}


	// Mostrar formulario de actualizacion
	@RequestMapping(method = RequestMethod.GET, value = { "/update/{id}" })
	public String updateTask(@PathVariable(value = "id") Integer id, Model model) {
		logger.info("[GET] Showing update task view GET");

		model.addAttribute("task", dao.select(id));

		return "task/update";
	}

	// Recibir datos del formulario y realizar la operacion UPDATE
	@RequestMapping(method = RequestMethod.POST, value = { "/saveupdate" })
	public String saveUpdate(@ModelAttribute("task") Task t, Model m) {

		if (dao.update(t.getId(), t) > 0) {
			logger.info("[POST] Save update " + t.getId());
			m.addAttribute("task", t);
			return "task/saveupdate";
		} else {
			logger.warn("[POST] An error occurred while trying to update task " + t.getId());
			m.addAttribute("message",
					"An error occurred while trying to update task " + t.getId() + ". Please, try again.");
			return "error";
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = { "/delete/{id}" })
	public String deleteTask(@PathVariable(value = "id") Integer id, Model model) {

		logger.info("[POST] Try to delete task " + id);
		String view = null;
		if (dao.delete(id) > 0) {
			logger.info("[POST] Task" + id + " has been deleted sucessfully.");
			view = "task/deleted";
			model.addAttribute("message", "Task " + id + " has been deleted sucessfully.");
		} else {
			logger.warn("A error occurred while trying to delete task " + id);
			view = "error";
			model.addAttribute("message", "A error occurred while trying to delete task " + id + ". Plase try again.");
		}
		return view;
	}

}
