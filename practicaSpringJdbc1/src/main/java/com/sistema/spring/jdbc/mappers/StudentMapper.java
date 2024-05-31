package com.sistema.spring.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sistema.spring.jdbc.models.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student tempStudent = new Student();

		tempStudent.setId(rs.getInt("ID"));
		tempStudent.setName(rs.getString("NAME"));
		tempStudent.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
		tempStudent.setCategory(rs.getString("CATEGORY"));
		tempStudent.setDistrict(rs.getString("DISTRICT"));

		return tempStudent;
	}

}
