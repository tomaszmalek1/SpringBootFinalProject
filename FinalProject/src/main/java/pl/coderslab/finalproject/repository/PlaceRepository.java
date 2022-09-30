package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.Place;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    @Query("select p from Place p where p.user.id = ?1")
    List<Place> findCountryByUserId(Long userId);
}
