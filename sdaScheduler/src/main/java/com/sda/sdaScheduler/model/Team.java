package com.sda.sdaScheduler.model;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(schema = "sda_schedule", name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTeam")
	int idTeam;
	@Column(name = "name")
	String name;
	@Column(name = "maxStudents")
	int maxStudents;
	
	
	@OneToMany(mappedBy = "team")
	List<Person> studentList;
	@OneToMany(mappedBy = "team")
	List<Module> moduleList;
	
	
	public Team() {}
	
	public Team(int idTeam, String name, int maxStudents) {
		this.idTeam = idTeam;
		this.name = name;
		this.maxStudents = maxStudents;
	}
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	@Override
	public String toString() {
		return "Team [idTeam=" + idTeam + ", name=" + name + ", maxStudents=" + maxStudents + ", studentList="
				+ studentList + ", moduleList=" + moduleList + "\n";
	}

	
	
}
