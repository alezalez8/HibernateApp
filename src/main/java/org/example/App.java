package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            /*Person person = new Person("Aleks", 49);
            Passport passport = new Passport(12345);
            person.setPassport(passport);*/
           /* Passport passport = session.get(Passport.class, 22);
            System.out.println(passport.getPerson().getName() + ", " + passport.getPerson().getAge());*/
            //Person person = session.get(Person.class, 23);
            //person.getPassport().setPassportNumber(7777777);
            //session.delete(person);  // hibernate
            //session.remove(person); // jpa
            //session.update(person);
            Person person = new Person("Gena", 49);
            Passport passport = new Passport(555555);

            person.setPassport(passport);
            session.save(person);


            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
