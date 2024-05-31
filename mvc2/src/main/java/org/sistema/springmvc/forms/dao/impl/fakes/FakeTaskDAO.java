package org.sistema.springmvc.forms.dao.impl.fakes;

import java.util.Collection;
import java.util.List;

import org.sistema.springmvc.forms.dao.TaskDAO;
import org.sistema.springmvc.forms.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;

public class FakeTaskDAO implements TaskDAO {

	@Autowired
	private FakeDatasource fds;

    @Autowired
    public void setFds(FakeDatasource fds) {
        this.fds = fds;
    }
	
	@Override
	public int create(Task task) {
		if (fds.getTaskTable().isEmpty()) {
			task.setId(0);
			return 0;
		} else {
			task.setId(fds.getTaskTable().size() + 1);
		}
		fds.getTaskTable().add(task);
		
		return task.getId();
	}

	@Override
	public Task select(Integer id) {

		List<Task> tasks = (List<Task>) selectAll();

		Task result = null;

		for (Task t : tasks) {
			if (t.getId() == id) {
				result = t;
			}
		}

		return result;
	}

	@Override
	public Collection<Task> selectAll() {
		return fds.getTaskTable();
	}

	@Override
	public int update(Integer id, Task task) {
		for (int i = 0; i < fds.getTaskTable().size(); i++) {
			if (fds.getTaskTable().get(i).getId() == id) {
				fds.getTaskTable().set(id, task);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int delete(Integer id) {

		for (Task t : fds.getTaskTable()) {
			if (t.getId() == id) {
				fds.getTaskTable().remove(id.intValue());
				return 1;
			}
		}
		return 0;
	}

}
