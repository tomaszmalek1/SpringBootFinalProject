package pl.coderslab.finalproject.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = " Wartość nie może być pusta!")
    private String name;
    @ManyToOne
    private Plan plan;
    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    private List<City> cityList;

    public Country(long id, String name, LocalDate firstDate, LocalDate lastDate, Plan plan, List<City> cityList) {
        this.id = id;
        this.name = name;
        this.plan = plan;
        this.cityList = cityList;
    }

    public Country() {
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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
