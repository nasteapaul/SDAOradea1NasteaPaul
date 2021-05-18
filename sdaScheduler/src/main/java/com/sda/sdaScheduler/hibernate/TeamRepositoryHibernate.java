package com.sda.sdaScheduler.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.sdaScheduler.model.Team;

public class TeamRepositoryHibernate {

	
	public static Team getTeamById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Team team = session.find(Team.class, id);
            session.saveOrUpdate(team);
            System.out.println(team);
            return team;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public static Team saveTeam(Team team) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.save(team);
				System.out.println(team);
				transaction.commit();
				return team;
				
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static void UpdateTeam(Team team) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.update(team);
				System.out.println(team);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteFromTeam(Team team) {
		
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
				session.delete(team);
				System.out.println(team);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
