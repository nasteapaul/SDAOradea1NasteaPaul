package com.sda.sdaScheduler.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sda.sdaScheduler.model.Module;
import com.sda.sdaScheduler.model.Team;

public class ModuleRepositoryHibernate {

	public static Module getModuleById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Module module = session.find(Module.class, id);
            session.saveOrUpdate(module);
            System.out.println(module);
            return module;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public static Module saveModule(Module module) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.save(module);
				System.out.println(module);
				transaction.commit();
				return module;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static void updateModule(Module module) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.update(module);
				System.out.println(module);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteFromTeam(Module module) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.delete(module);
				System.out.println(module);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	 public static List<Module> selectGroupByMaxStudents() {
	        try {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            Query q = session.createQuery("SELECT module from Module module "
	                    + "JOIN module.team	team "
	                    + "WHERE team.maxStudents < 20 ");
	            
	            return (List<Module>)q.getResultList();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	
}
