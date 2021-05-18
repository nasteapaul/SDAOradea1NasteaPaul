package com.sda.sdaScheduler.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "sda_schedule", name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPerson")
	int idPerson;
	@Column(name = "firstName")
	String firstName;
	@Column(name = "lastName")
	String lastName;	
	@Column(name = "email")
	String email;
	@Column(name = "isTrainer")
	boolean isTrainer;
	
	@ManyToOne
	@JoinColumn(name  = "idTeam" , nullable = true)
	Team team ;
	
	@OneToMany(mappedBy = "person")
	List<Module> moduleList;
	
	
	public Person() {}
	
	public Person(int idPerson, String firstName,String lastName, String email, boolean isTrainer) {
		this.idPerson = idPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isTrainer = isTrainer;
		
		
	}
	
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isTrainer() {
		return isTrainer;
	}

	public void setTrainer(boolean isTrainer) {
		this.isTrainer = isTrainer;
	}

	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson +" firstName is:  " + firstName + " lastName=" + lastName + ", email=" + email + ", isTrainer="
				+ isTrainer + ", moduleList=" + moduleList + "\n";
	}

	
	
	
	
}
