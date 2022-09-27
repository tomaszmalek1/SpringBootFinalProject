package pl.coderslab.finalproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Wartość nie może być pusta!")
    private String name;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate firstDate;
    private int arrivalCost;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate lastDate;
    private int sleepingCost;
    private int oneDayFoodCost;

    @ManyToOne
    private Country country;

    @ManyToOne
    private User user;

    public City(long id, String name, LocalDate firstDate, int arrivalCost, LocalDate lastDate, int sleepingCost, int oneDayFoodCost) {
        this.id = id;
        this.name = name;
        this.firstDate = firstDate;
        this.arrivalCost = arrivalCost;
        this.lastDate = lastDate;
        this.sleepingCost = sleepingCost;
        this.oneDayFoodCost = oneDayFoodCost;
    }

    public City() {
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

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
    }

    public int getArrivalCost() {
        return arrivalCost;
    }

    public void setArrivalCost(int arrivalCost) {
        this.arrivalCost = arrivalCost;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSleepingCost() {
        return sleepingCost;
    }

    public void setSleepingCost(int sleepingCost) {
        this.sleepingCost = sleepingCost;
    }

    public int getOneDayFoodCost() {
        return oneDayFoodCost;
    }

    public void setOneDayFoodCost(int oneDayFoodCost) {
        this.oneDayFoodCost = oneDayFoodCost;
    }
}
