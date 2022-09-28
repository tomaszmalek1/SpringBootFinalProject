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
    private List<Country> countries;
    @OneToMany
    private List<User> users;
    @OneToMany
    private List<City> cities;
    @OneToMany
    private List<Place> places;

    public Plan(long id, String description, List<Country> countries, List<User> users, List<City> cities, List<Place> places) {
        this.id = id;
        this.description = description;
        this.countries = countries;
        this.users = users;
        this.cities = cities;
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

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
