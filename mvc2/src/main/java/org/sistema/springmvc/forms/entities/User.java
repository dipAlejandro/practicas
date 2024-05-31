package org.sistema.springmvc.forms.entities;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer id;
	private String login;
	private String description;
	private String password;
	private Set<Task> tasks = new HashSet<Task>();

	public User(Integer id, String login, String description, String password) {

		this.id = id;
		this.login = login;
		this.description = description;
		this.password = password;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", description=" + description + ", password=" + password + "]";
	}
}
