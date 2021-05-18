package com.sda.sdaScheduler.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.sdaScheduler.model.Course;

public class CourseRepositoryHibernate {

	
	public static Course getCourseById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Course course = session.find(Course.class, id);
            session.saveOrUpdate(course);
            System.out.println(course);
            return course;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public static Course saveCourse(Course course) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.save(course);
				System.out.println(course);
				transaction.commit();
				return course;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static void updateCourse(Course course) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.update(course);
				System.out.println(course);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteFromCourse(Course course) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.delete(course);
				System.out.println(course);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
