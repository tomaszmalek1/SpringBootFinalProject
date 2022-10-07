package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    void add(Country country);
    List<Country> get();
    void delete(Long id);
    Optional<Country> get(Long id);
}
