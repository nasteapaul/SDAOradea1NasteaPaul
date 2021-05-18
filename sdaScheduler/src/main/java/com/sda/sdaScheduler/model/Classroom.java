package com.sda.sdaScheduler.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(schema = "sda_schedule", name = "classroom")
public class Classroom {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idClassroom;
	String name;
	String address;
	
	@OneToMany(mappedBy = "classroom")
	List<Module> moduleList;
	
	
	public Classroom() {}
	public Classroom(int idClassroom, String name, String address) {
		this.idClassroom = idClassroom;
		this.name = name;
		this.address = address;
	}
	public int getIdClassroom() {
		return idClassroom;
	}
	public void setIdClassroom(int idClassroom) {
		this.idClassroom = idClassroom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Classroom [idClassroom=" + idClassroom + ", name=" + name + ", address=" + address + ", moduleList="
				+ moduleList + "\n";
	}
	
	
	
	
}
