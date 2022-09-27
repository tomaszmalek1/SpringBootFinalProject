package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Place;

import java.util.List;

public interface PlaceService {
    void add(Place place);

    List<Place> get();
}
