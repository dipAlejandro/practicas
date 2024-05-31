package org.sistema.springmvc.forms.dao;

import java.util.Collection;

import org.sistema.springmvc.forms.entities.User;

public interface UserDAO {

	public int create(User user);

	public User select(Integer id);

	public Collection<User> selectAll();

	public int update(Integer id, User user);

	public int delete(Integer id);
}
