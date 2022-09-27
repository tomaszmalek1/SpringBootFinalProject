package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Country;

import java.util.List;

public interface CountryService {
    void add(Country country);

    List<Country> get();

}
