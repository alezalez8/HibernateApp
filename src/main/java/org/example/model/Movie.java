package org.example.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int age;


    public Movie() {
    }

    public Movie(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actorList;

    // =================== get set ============================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Actor> getActors() {
        return actorList;
    }

    public void setActors(List<Actor> actorList) {
        this.actorList = actorList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (age != movie.age) return false;
        return name != null ? name.equals(movie.name) : movie.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
