package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    void add(City city);

    List<City> get();

    void delete(Long id);

    Optional<City> get(Long id);
}
