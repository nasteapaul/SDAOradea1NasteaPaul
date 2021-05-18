package com.sda.sdaScheduler.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.sdaScheduler.model.Classroom;

public class ClassroomRepositoryHibernate {

	public static Classroom getClassroomById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Classroom classroom = session.find(Classroom.class, id);
            session.saveOrUpdate(classroom);
            System.out.println(classroom);
            return classroom;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public static Classroom saveClassroom(Classroom classroom) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.save(classroom);
				System.out.println(classroom);
				transaction.commit();
				return classroom;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static void updateClassroom(Classroom classroom) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.update(classroom);
				System.out.println(classroom);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteFromClassroom(Classroom classroom) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.delete(classroom);
				System.out.println(classroom);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
