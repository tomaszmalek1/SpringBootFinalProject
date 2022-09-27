package pl.coderslab.finalproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.model.Place;
import pl.coderslab.finalproject.repository.PlaceRepository;

import java.util.List;
@Service
@Primary
public class JpaPlaceService implements PlaceService {
    private final PlaceRepository placeRepository;

    public JpaPlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void add(Place place) {
        placeRepository.save(place);
    }

    @Override
    public List<Place> get() {
        return placeRepository.findAll();
    }
}
