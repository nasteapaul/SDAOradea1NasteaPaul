package com.sda.sdaScheduler.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sda.sdaScheduler.model.Classroom;

public class ClassroomRepository {

	private static String url = "jdbc:mysql://localhost:3306/sda_schedule?serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "asdasdA1.";
	

	public static List<Classroom> getAllTeams() {
		List<Classroom> classroomList = new ArrayList<Classroom>();
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM classroom ");
			while (rs.next()) {
				int idClassroom = rs.getInt("idClassroom");
				String name = rs.getString("name");
				String address = rs.getString("address");
				Classroom c = new Classroom(idClassroom, name, address);
				classroomList.add(c);
				System.out.println(idClassroom + ", " + name + ", " + address);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		return classroomList;
	}
		

	public static void insertNewClassroom(String name, String address) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(" INSERT INTO team(name ,address)" + " VALUES ('" + name + "','" + address + "')");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	public static void deleteFromClassrom(int idClassroom) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete * from team where idTeam = " +idClassroom);
			}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}

	
	public static void updateClassroom (int idClassroom, String newClassroomName, Integer newClassroomAddress) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE team SET name = '" + newClassroomName + "', " + "address = '" + newClassroomAddress
                    + "' WHERE idTeam = " + idClassroom);
			}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
	
	}
	
	
	
	public static void selectNuLL() {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from classroom where name is null or address is null");
			while (rs.next()) {
				int idClassroom = rs.getInt("idClassroom");
				String name = rs.getString("name");
				String address = rs.getString("address");
				System.out.println(idClassroom + ", " + name + ", " + address);
			}}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void updateWhereNulL(int idClassroom, String newClassroomName, int newClassroomAddress) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE team SET name = '" + newClassroomName + "', " + "address = '" + newClassroomAddress
                    + "' WHERE idTeam = " + idClassroom + "and (name is null or address is null");
			}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	public static void insertNewClassroomPreparedStatement(String name, String address) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement prdstmt = conn.prepareStatement("insert into team (name , address) values (?, ?)");
			prdstmt.setString(1, name);
			prdstmt.setString(2, address);
			int ret = prdstmt.executeUpdate();
			System.out.println("Insert return: " + (ret == 1 ? "OK" : "ERROR"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	
	
	
}
