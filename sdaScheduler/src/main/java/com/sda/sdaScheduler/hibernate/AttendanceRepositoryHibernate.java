package com.sda.sdaScheduler.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.sdaScheduler.model.Attendance;

public class AttendanceRepositoryHibernate {

	
	
	public static Attendance getAttendanceById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Attendance attendance = session.find(Attendance.class, id);
            session.saveOrUpdate(attendance);
            System.out.println(attendance);
            return attendance;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public static Attendance saveAttendance(Attendance attendance) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.save(attendance);
				System.out.println(attendance);
				transaction.commit();
				return attendance;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static void updateAttendance(Attendance attendance) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.update(attendance);
				System.out.println(attendance);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteFromTeam(Attendance attendance) {
		Transaction transaction = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
				session.delete(attendance);
				System.out.println(attendance);
				transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
