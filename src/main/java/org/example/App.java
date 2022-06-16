package org.example;

import org.example.model.*;
import org.hibernate.Hibernate;
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
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Arrays.asList() почти то же, что и List.of(), первый изменяемый(сами элементы, но не размер)
            Person person = session.get(Person.class, 1);
            System.out.println("Получили человека");

            session.getTransaction().commit();
            System.out.println("Session is end");

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Open second session");

            person = (Person) session.merge(person);

            System.out.println("2:  " + person.getItems());

            session.getTransaction().commit();
        }


    }
}
