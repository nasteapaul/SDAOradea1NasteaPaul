package com.sda.sdaScheduler.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sda.sdaScheduler.model.Team;

public class TeamRepository {
	
	private static String url = "jdbc:mysql://localhost:3306/sda_schedule?serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "asdasdA1.";
	

	public static List<Team> getAllTeams() {
		List<Team> teamList = new ArrayList<Team>();
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM team ");
			while (rs.next()) {
				int idTeam = rs.getInt("idTeam");
				String name = rs.getString("name");
				int maxStudents = rs.getInt("maxStudents");
				Team t = new Team(idTeam, name, maxStudents);
				teamList.add(t);
				System.out.println(idTeam + ", " + name + ", " + maxStudents);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return teamList;
	}

	public static void insertNewTeam(String name, int maxStudents) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(" INSERT INTO team(name ,maxStudents)" + " VALUES ('" + name + "','" + maxStudents + "')");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	public static void deleteFromTeam(int idTeam) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete * from team where idTeam = " +idTeam);
			}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}

	
	public static void updateTeam (int idTeam, String newTeamName, Integer newMaxStudents) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE team SET name = '" + newTeamName + "', " + "maxStudents = '" + newMaxStudents
                    + "' WHERE idTeam = " + idTeam);
			}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
	
	}
	
	
	
	public static void selectNuLL() {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from team where name is null or maxStudents is null");
			while (rs.next()) {
				int idTeam = rs.getInt("idTeam");
				String name = rs.getString("name");
				int maxStudents = rs.getInt("maxStudents");
				System.out.println(idTeam + ", " + name + ", " + maxStudents);
			}}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void updateWhereNulL(int idTeam, String newTeamName, int newMaxStudents) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE team SET name = '" + newTeamName + "', " + "maxStudents = '" + newMaxStudents
                    + "' WHERE idTeam = " + idTeam + "and (name is null or maxStudents is null");
			}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	public static void insertNewTeamPreparedStatement(String name, int maxStudents) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement prdstmt = conn.prepareStatement("insert into team (name , maxStudents) values (?, ?)");
			prdstmt.setString(1, name);
			prdstmt.setInt(2, maxStudents);
			int ret = prdstmt.executeUpdate();
			System.out.println("Insert return: " + (ret == 1 ? "OK" : "ERROR"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
		
	}

