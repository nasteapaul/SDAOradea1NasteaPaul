package com.sda.sdaScheduler.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.sda.sdaScheduler.model.Attendance;
import com.sda.sdaScheduler.model.Classroom;
import com.sda.sdaScheduler.model.Course;
import com.sda.sdaScheduler.model.Module;
import com.sda.sdaScheduler.model.Person;
import com.sda.sdaScheduler.model.Team;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sda_schedule?serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "asdasdA1.");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Team.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Classroom.class);
                configuration.addAnnotatedClass(Module.class);
                configuration.addAnnotatedClass(Attendance.class);
                
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    
}