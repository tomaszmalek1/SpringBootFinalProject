package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.model.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    @Query("select c from City c where c.country.plan.user.id = ?1")
    List<City> findCitiesByUserId(Long userId);
}
