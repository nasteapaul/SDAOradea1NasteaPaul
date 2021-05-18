package com.sda.sdaScheduler.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "sda_schedule", name = "attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAttendance;
	private String isPresent;
	private String comments;
	
	
	@ManyToOne
	@JoinColumn(name  = "idModule")
	Module module;
	@ManyToOne
	@JoinColumn(name  = "idPerson")
	Person person;
	
	public Attendance() {}
	public Attendance(int idAttendance, String isPresent, String comments) {
		this.idAttendance = idAttendance;
		this.isPresent = isPresent;
		this.comments = comments;
	}


	public int getIdAttendance() {
		return idAttendance;
	}


	public void setIdAttendance(int idAttendance) {
		this.idAttendance = idAttendance;
	}


	public String getIsPresent() {
		return isPresent;
	}


	public void setIsPresent(String isPresent) {
		this.isPresent = isPresent;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Attendance [idAttendance=" + idAttendance + ", isPresent=" + isPresent + ", comments=" + comments + "]";
	}
	
	
	

	
	
	
	


	
	
}
