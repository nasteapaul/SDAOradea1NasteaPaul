package com.sda.sdaScheduler.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "sda_schedule", name = "module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModule;
	private String startDate;
	private String endDate;
	
	@ManyToOne
	@JoinColumn(name  = "idTrainer")
	Person person;
	@ManyToOne
	@JoinColumn(name  = "idTeam")
	Team team;
	@ManyToOne
	@JoinColumn(name  = "idCourse")
	Course course;
	@ManyToOne
	@JoinColumn(name  = "idClassroom")
	Classroom classroom;
	
	public Module(){}
	public Module(int idModule, String startDate, String endDate) {
		this.idModule = idModule;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public int getIdModule() {
		return idModule;
	}


	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Module [idModule=" + idModule + ", startDate=" + startDate + ", endDate=" + endDate + "\n";
	}

	
	


	


	
	
	
	
}
