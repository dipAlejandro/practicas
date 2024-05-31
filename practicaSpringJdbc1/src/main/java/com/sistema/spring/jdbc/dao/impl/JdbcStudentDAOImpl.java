package com.sistema.spring.jdbc.dao.impl;

import java.sql.Date;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sistema.spring.jdbc.dao.IStudentDAO;
import com.sistema.spring.jdbc.mappers.StudentMapper;
import com.sistema.spring.jdbc.models.Student;

public class JdbcStudentDAOImpl implements IStudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public int insert(String name, Date dateOfBirth, String category, String district) {
		String sql = "INSERT INTO Student(NAME, DATE_OF_BIRTH, CATEGORY, DISTRICT) VALUES(?, ?, ?, ?);";

		return jdbcTemplate.update(sql, name, dateOfBirth, category, district);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student selectById(Integer id) {

		String sql = "SELECT * FROM Student WHERE ID = ?";

		return (Student) jdbcTemplate.queryForObject(sql, new Object[] { id }, new StudentMapper());

	}

	@Override
	public Collection<Student> selectAll() {

		String sql = "SELECT * FROM Student;";

		return jdbcTemplate.query(sql, new StudentMapper());
	}

	@Override
	public int update(Student s) {
		String sql = "UPDATE Student SET NAME=?, DATE_OF_BIRTH=?, CATEGORY=?, DISTRICT=? WHERE ID=?;";

		return jdbcTemplate.update(sql, s.getName(), s.getDateOfBirth(), s.getCategory(), s.getDistrict(), s.getId());
	}

	@Override
	public int delete(Integer id) {

		String sql = "DELETE FROM Student WHERE ID =?;";

		return jdbcTemplate.update(sql, id);
	}

}
