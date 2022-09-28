package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {
    void add(Place place);
    List<Place> get();
    void delete(Long id);
    Optional<Place> get(Long id);
    void update(Place place);
}
