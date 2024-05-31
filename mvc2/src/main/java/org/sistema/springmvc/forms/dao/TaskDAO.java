package org.sistema.springmvc.forms.dao;

import java.util.Collection;

import org.sistema.springmvc.forms.entities.Task;

public interface TaskDAO {
	public int create(Task task);

	public Task select(Integer id);

	public Collection<Task> selectAll();

	public int update(Integer id, Task task);

	public int delete(Integer id);
}
