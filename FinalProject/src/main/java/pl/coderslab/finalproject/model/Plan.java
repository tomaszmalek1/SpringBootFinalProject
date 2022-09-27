//package pl.coderslab.finalproject.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "plans")
//public class Plan {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long id;
//    private String description;
////    @ManyToMany
//    @OneToOne
//    private Country country;
//    @OneToMany
//    private User user;
//    @OneToMany
//    private City city;
//    @OneToMany
//    private Place place;
//
//
//    public Plan(long id, String description, Country country, User user, City city, Place place) {
//        this.id = id;
//        this.description = description;
//        this.country = country;
//        this.user = user;
//        this.city = city;
//        this.place = place;
//    }
//
//    public Plan() {
//
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
//
//    public Place getPlace() {
//        return place;
//    }
//
//    public void setPlace(Place place) {
//        this.place = place;
//    }
//}
