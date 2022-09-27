package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
