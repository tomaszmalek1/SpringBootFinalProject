package pl.coderslab.finalproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String description;
    @OneToMany
    private List<Place> places;

    public Plan(long id, String description, List<Country> countries, List<User> users, List<City> cities, List<Place> places) {
        this.id = id;
        this.description = description;
        this.places = places;
    }

    public Plan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
