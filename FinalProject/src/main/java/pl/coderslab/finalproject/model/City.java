package pl.coderslab.finalproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = " Wartość nie może być pusta")
    private String name;
    @NotNull(message = " Wartość nie może być pusta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate firstDate;
    @NotNull(message = " Wartość nie może być pusta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate lastDate;
    @NotNull(message = " Wartość nie może być pusta")
    private int arrivalCost;
    @NotNull(message = " Wartość nie może być pusta")
    private int sleepingCost;
    @NotNull(message = " Wartość nie może być pusta")
    private int oneDayFoodCost;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
    private List<Place> placeList;

    public City(long id, String name, LocalDate firstDate, LocalDate lastDate, int arrivalCost, int sleepingCost, int oneDayFoodCost, Country country, List<Place> placeList) {
        this.id = id;
        this.name = name;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.arrivalCost = arrivalCost;
        this.sleepingCost = sleepingCost;
        this.oneDayFoodCost = oneDayFoodCost;
        this.country = country;
        this.placeList = placeList;
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

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    public int getArrivalCost() {
        return arrivalCost;
    }

    public void setArrivalCost(int arrivalCost) {
        this.arrivalCost = arrivalCost;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }
}
