package com.sda.sdaScheduler.hibernate;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sda.sdaScheduler.model.Person;
import com.sda.sdaScheduler.model.Team;

public class PersonRepositoryHibernate {

	public static Person getPersonById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Person person = session.find(Person.class, id);
            session.saveOrUpdate(person);
            System.out.println(person);
            return person;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public static Person savePerson(Person person) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.save(person);
				System.out.println(person);
				transaction.commit();
				return person;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static void updatePerson(Person person) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.update(person);
				System.out.println(person);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteFromTeam(Person person) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.delete(person);
				System.out.println(person);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	 public static List<Person> selectPersonByName(String personName) {
	        try {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            Query q = session.createQuery("SELECT person from Person person "
	                    + "where person.firstName like :personName");
	            q.setParameter("personName", personName);
	            return q.getResultList();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	 
	 public static List<Person> selectAllTrainer(boolean isTrainer){
		 try {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            Query q = session.createQuery("select person from Person person " + "where person.isTrainer like  :isTrainer");
	            q.setParameter("isTrainer", isTrainer);
	            return q.getResultList();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	 }
	 
	 public static List<Person> selectByFnAndLn(String firstName, String lastName){
		 try {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            Query q = session.createQuery("select person from Person person " + "where person.firstName like  :firstName " + "and person.lastName like :lastName");
	            q.setParameter("firstName", firstName);
	            q.setParameter("lastName", lastName);
	            return q.getResultList();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	 }
	 
	 public static List<Team> selectTeamByStudentName(String studentName) {
	        try {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            Query q = session.createQuery("SELECT team from Team team "
	                    + "JOIN team.studentList student "
	                    + "WHERE student.firstName = :name ");
	            q.setParameter("name", studentName);
	            
	            return (List<Team>)q.getResultList();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	 
	 

}


