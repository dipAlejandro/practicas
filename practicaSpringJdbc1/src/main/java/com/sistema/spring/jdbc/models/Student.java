package com.sistema.spring.jdbc.models;

import java.sql.Date;

public class Student {

	private Integer id;
	private String name;
	private Date dateOfBirth;
	private String category;
	private String district;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Student [\n id: " + id + "\n name: " + name + "\n date of birth: " + dateOfBirth + "\n category: " + category
				+ "\n district: " + district + "\n]";
	}

}
