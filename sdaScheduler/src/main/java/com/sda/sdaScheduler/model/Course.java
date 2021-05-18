package com.sda.sdaScheduler.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "sda_schedule", name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCourse;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "course")
	List<Module> moduleList;
	
	
	public Course() {}
	public Course(int idCourse, String name, String description) {
		this.idCourse = idCourse;
		this.name = name;
		this.description = description;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", name=" + name + ", description=" + description + ", moduleList="
				+ moduleList + "\n";
	}

	
	
	
	
}
