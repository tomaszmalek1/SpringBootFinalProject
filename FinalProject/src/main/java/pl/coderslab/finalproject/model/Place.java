package pl.coderslab.finalproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalTime;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Podaj nazwę zabytku")
    private String name;
    @NotBlank(message = "Opis nie może być pusty")
    private String description;
    @Pattern(regexp = "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})", message = "Podana wartość nie jest adresem strony internetowej")
    private String html;
    @NotNull(message = "Uzupełnij cenę biletu")
    private int ticketCost;
    @NotNull(message = "Podaj godzinę otwarcia")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime firstOpenHours;
    @NotNull(message = "Podaj godzinę zamknięcia")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime lastOpenHours;
    @ManyToOne
    private City city;

    public Place(long id, String name, String description, String html, int ticketCost, LocalTime firstOpenHours, LocalTime lastOpenHours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.html = html;
        this.ticketCost = ticketCost;
        this.firstOpenHours = firstOpenHours;
        this.lastOpenHours = lastOpenHours;
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
}
