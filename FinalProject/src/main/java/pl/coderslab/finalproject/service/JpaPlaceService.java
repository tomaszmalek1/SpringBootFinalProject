package pl.coderslab.finalproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.Place;
import pl.coderslab.finalproject.repository.PlaceRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public Optional<Place> get(Long id) {
        return placeRepository.findById(id);
    }

    @Override
    public void update(Place place) {
        if (get(place.getId()).isPresent()) {
            placeRepository.save(place);
        }
    }
}
