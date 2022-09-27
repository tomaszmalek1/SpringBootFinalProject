package pl.coderslab.finalproject.model;


import javax.persistence.*;

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
    private String firstOpenHours;
    private String lastOpenHours;
    @ManyToOne
    private City city;
    @ManyToOne
    private User user;

    @ManyToOne
    private Country country;

    public Place(long id, String name, String description, String html, int ticketCost, String firstOpenHours, String lastOpenHours, City cityId, User userId, Country countryId) {
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

    public String getFirstOpenHours() {
        return firstOpenHours;
    }

    public void setFirstOpenHours(String firstOpenHours) {
        this.firstOpenHours = firstOpenHours;
    }

    public String getLastOpenHours() {
        return lastOpenHours;
    }

    public void setLastOpenHours(String lastOpenHours) {
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
