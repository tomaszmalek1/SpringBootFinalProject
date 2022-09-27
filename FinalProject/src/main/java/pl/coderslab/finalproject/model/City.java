package pl.coderslab.finalproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Wartość nie może być pusta!")
    private String name;
    @NotBlank(message = "Wartość nie może być pusta!")
    private String firstDate;
    //    @Pattern(regexp = "\\d+", message = "Podaj wartość liczbową")
    private int arrivalCost;
    @NotBlank(message = "Wartość nie może być pusta!")
    private String lastDate;

    private int sleepingCost;
    private int oneDayFoodCost;

    @ManyToOne
    private Country country;

    @ManyToOne
    private User user;

    public City(long id, String name, String firstDate, int arrivalCost, String lastDate, int sleepingCost, int oneDayFoodCost) {
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

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public int getArrivalCost() {
        return arrivalCost;
    }

    public void setArrivalCost(int arrivalCost) {
        this.arrivalCost = arrivalCost;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
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
