package org.example;

import org.example.model.*;
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
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();


            session.beginTransaction();
           /* Movie movie = new Movie("Pulp fiction", 1994);
            Actor actor1 = new Actor("Harvey Keitel", 81);
            Actor actor2 = new Actor("Samuel L. Jackson", 72);*/

            // Arrays.asList() почти то же, что и List.of(), первый изменяемый(сами элементы, но не размер)
            /*movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));*/

           /* Movie movie = new Movie("Reservoir Dogs", 1992);
            Actor actor = session.get(Actor.class, 4);
            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
            actor.getMovies().add(movie);
            session.save(movie);*/

            Actor actor = session.get(Actor.class, 4);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);
            session.getTransaction().commit();
        }


    }
}
