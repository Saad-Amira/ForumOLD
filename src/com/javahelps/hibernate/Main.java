package com.javahelps.hibernate;

import java.util.List;
import java.util.Properties;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.forum.entities.Category;

public class Main {
    // Create the SessionFactory when you start the application.
    private static final SessionFactory SESSION_FACTORY;

    /**
     * Initialize the SessionFactory instance.
     */
    static {
        // Create a Configuration object.
        Configuration config = new Configuration();
        // Configure using the application resource named hibernate.cfg.xml.
        config.configure();
        // Extract the properties from the configuration file.
        Properties prop = config.getProperties();

        // Create StandardServiceRegistryBuilder using the properties.
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(prop);

        // Build a ServiceRegistry
        ServiceRegistry registry = builder.build();

        // Create the SessionFactory using the ServiceRegistry
        SESSION_FACTORY = config.buildSessionFactory(registry);
    }

    public static void main(String[] args) {
        // Create two Students
        create(1, "arij",19); // Alice will get an id 1
     /*   create(2, "Bob", 20); // Bob will get an id 2
        create(3, "Charlie", 25); // Charlie will get an id 3

        // Update the age of Bob using the id
        upate(2, "Bob", 25);

        // Delete the Alice from database
        delete(1);

        // Print all the Students
        List<Student> students = readAll();
        if (students != null) {
            for (Student stu : students) {
                System.out.println(stu);
            }
        }
*/
        // NEVER FORGET TO CLOSE THE SESSION_FACTORY
        SESSION_FACTORY.close();
    }

    /**
     * Create a new Student.
     *
     * @param name
     * @param age
     */
    public static void create(int id, String name, int age) {
        // Create a session
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            Category stu = new Category("toto1","toto2");
            stu.setIdCategory(13);
            stu.setStatus("activated");
           
           
            // Save the student
            session.save(stu);
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }

}