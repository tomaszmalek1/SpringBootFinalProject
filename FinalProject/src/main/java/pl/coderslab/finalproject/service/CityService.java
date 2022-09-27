package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Country;

import java.util.List;
import java.util.Optional;

public interface CityService {
    void add (City city);
    List<City> get();
}
