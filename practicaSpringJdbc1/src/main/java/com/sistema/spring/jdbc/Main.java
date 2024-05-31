package com.sistema.spring.jdbc;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sistema.spring.jdbc.dao.IStudentDAO;
import com.sistema.spring.jdbc.models.Student;

public class Main {

	private static ApplicationContext context;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("beans.xml");

		IStudentDAO dao = context.getBean("clientJdbcStudentDAOImpl", IStudentDAO.class);

		int rowsAffected = dao.insert("Rocio Quinteros", new Date(2009, 5, 3), "V-Az", "Tiro Suizo");

		if (rowsAffected > 0) {
			System.out.println("Estudiante agregado");
		}

		rowsAffected = dao.insert("Agustin Robledo", new Date(2005, 4, 4), "Am", "Tiro Suizo");

		if (rowsAffected > 0) {
			System.out.println("Estudiante agregado");
		}

		System.out.println("LISTA DE ALUMNOS: ");

		for (Student s : dao.selectAll()) {
			System.out.println(s.toString());
			System.out.println();
		}

		System.out.println("ALUMNO CON ID = 2");
		System.out.println(dao.selectById(2).toString());

		System.out.println("ACTUALIZAR ALUMNO: ");
		System.out.println(dao.selectById(1).toString());

		Student updateStudent = new Student();

		updateStudent.setId(1);
		updateStudent.setName("Rocio Maricel Quinteros");
		updateStudent.setDateOfBirth(new Date(2005, 4, 4));
		updateStudent.setCategory("V-A");
		updateStudent.setDistrict("Tiro Suizo");

		rowsAffected = dao.update(updateStudent);

		if (rowsAffected > 0) {
			System.out.println("ALUMNO ACTUALIZADO: ");
			System.out.println(dao.selectById(1).toString());
		}

		System.out.println("ELIMINAR ALUMNO CON ID = 2");

		rowsAffected = dao.delete(2);
		if (rowsAffected > 0) {
			System.out.println("ALUMNO ELIMINADO: ");
			System.out.println("LISTA DE ALUMNOS: ");

			for (Student s : dao.selectAll()) {
				System.out.println(s.toString());
				System.out.println();
			}
		}
	}

}
