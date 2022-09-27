package pl.coderslab.finalproject.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String html;
    private int ticketCost;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime firstOpenHours;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime lastOpenHours;
    @ManyToOne
    private City city;
    @ManyToOne
    private User user;

    @ManyToOne
    private Country country;

    public Place(long id, String name, String description, String html, int ticketCost, LocalTime firstOpenHours, LocalTime lastOpenHours, City cityId, User userId, Country countryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.html = html;
        this.ticketCost = ticketCost;
        this.firstOpenHours = firstOpenHours;
        this.lastOpenHours = lastOpenHours;
        this.city = cityId;
        this.user = userId;
        this.country = countryId;
    }

    public Place() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(int ticketCost) {
        this.ticketCost = ticketCost;
    }

    public LocalTime getFirstOpenHours() {
        return firstOpenHours;
    }

    public void setFirstOpenHours(LocalTime firstOpenHours) {
        this.firstOpenHours = firstOpenHours;
    }

    public LocalTime getLastOpenHours() {
        return lastOpenHours;
    }

    public void setLastOpenHours(LocalTime lastOpenHours) {
        this.lastOpenHours = lastOpenHours;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
