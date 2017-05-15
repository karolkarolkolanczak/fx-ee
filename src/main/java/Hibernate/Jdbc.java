package Hibernate;

import Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by a on 2017-05-14.
 */
public class Jdbc {
    public static void main(String[] args) {

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try{
            System.out.println("---- Creating new USER ---");
            User tempUser=new User("adam","kowalski","aaa","xxx","123@wp.pl");

            session.beginTransaction();

            session.save(tempUser);

            session.getTransaction().commit();
            System.out.println("--DONE--");
        }
        finally{
            factory.close();
        }
    }


    void addUser(){

    }



}
