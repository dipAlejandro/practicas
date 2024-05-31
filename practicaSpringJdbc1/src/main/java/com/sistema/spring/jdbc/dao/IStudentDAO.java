package com.sistema.spring.jdbc.dao;

import java.sql.Date;
import java.util.Collection;

import javax.sql.DataSource;

import com.sistema.spring.jdbc.models.Student;

public interface IStudentDAO {
	
	public void setDataSource(DataSource ds);
	
	public int insert(String name, Date dateOfBirth, String category, String district);
	
	public Student selectById(Integer id);
	
	public Collection<Student> selectAll();
	
	public int update(Student s);
	
	public int delete(Integer id);
}
