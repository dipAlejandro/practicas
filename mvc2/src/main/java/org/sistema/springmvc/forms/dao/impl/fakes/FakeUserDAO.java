package org.sistema.springmvc.forms.dao.impl.fakes;

import java.util.Collection;
import java.util.List;

import org.sistema.springmvc.forms.dao.UserDAO;
import org.sistema.springmvc.forms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

public class FakeUserDAO implements UserDAO {

	@Autowired
	private FakeDatasource fds;
	
    @Autowired
    public void setFds(FakeDatasource fds) {
        this.fds = fds;
    }
	
	@Override
	public int delete(Integer id) {
		List<User> users = (List<User>) selectAll();

		for (User u : users) {
			if (u.getId() == id) {
				users.remove(id.intValue());

				return 1;
			}
		}
		return 0;
	}

	@Override
	public int create(User user) {
		if (fds.getUserTable().isEmpty()) {
			user.setId(0);
		} else {
			user.setId(fds.getUserTable().size() + 1);
		}

		fds.getUserTable().add(user);

		return user.getId();
	}

	@Override
	public User select(Integer id) {

		List<User> users = (List<User>) selectAll();
		User result = null;

		for (User u : users) {
			if (u.getId() == id) {
				result = u;
			}
		}

		return result;
	}

	@Override
	public Collection<User> selectAll() {

		return fds.getUserTable();
	}

	@Override
	public int update(Integer id, User user) {

		List<User> users = (List<User>) selectAll();

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.set(i, user);
				return 1;
			}
		}

		return 0;
	}

}
