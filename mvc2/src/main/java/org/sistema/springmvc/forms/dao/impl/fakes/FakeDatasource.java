package org.sistema.springmvc.forms.dao.impl.fakes;

import java.util.ArrayList;
import java.util.List;

import org.sistema.springmvc.forms.entities.Task;
import org.sistema.springmvc.forms.entities.User;

public class FakeDatasource {
	private List<User> userTable = new ArrayList<User>();
	private List<Task> taskTable = new ArrayList<Task>();
	
	public FakeDatasource() {

		User user1 = new User(1, "sJobs", "Apple CEO", "stewie");
		User user2 = new User(2, "lellison", "Oracle CEO", "larry");
		User user3 = new User(3, "bgates", "Microsoft CEO", "imrich");
		User user4 = new User(4, "mzuckerberg", "Facebook CEO", "selfie");

		userTable.add(user1);
		userTable.add(user2);
		userTable.add(user3);
		userTable.add(user4);
	}

	public List<User> getUserTable() {
		return userTable;
	}

	public void setUserTable(List<User> userTable) {
		this.userTable = userTable;
	}

	public List<Task> getTaskTable() {
		return taskTable;
	}

	public void setTaskTable(List<Task> taskTable) {
		this.taskTable = taskTable;
	}
	
	
}
