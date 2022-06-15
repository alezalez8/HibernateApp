package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
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
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            /*Person person = session.get(Person.class, 2);
            Item item = new Item("new Item for pers 2", person);
            person.getItems().add(item);
            List<Item> items = person.getItems();
            System.out.println(items);
            session.save(item);*/
            Person person = new Person("Aleksandr", 49);

            Item item = new Item("1 billion buks", person);

            person.setItems(new ArrayList<>(Collections.singletonList(item)));
            //session.save(person);
            session.save(item);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
