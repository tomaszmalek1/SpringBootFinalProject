package pl.coderslab.finalproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank(message = " Wartość nie może być pusta")
    private String description;
    @NotNull(message = " Wartość nie może być pusta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate firstDate;
    @NotNull(message = " Wartość nie może być pusta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate lastDate;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "plan", cascade = CascadeType.REMOVE)
    private List<Country> countryList;

    public Plan(long id, String description, LocalDate firstDate, LocalDate lastDate, User user, List<Country> countryList) {
        this.id = id;
        this.description = description;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.user = user;
        this.countryList = countryList;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
