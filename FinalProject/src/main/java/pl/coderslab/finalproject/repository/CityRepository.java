package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Country;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    @Query("select c from City c where c.user.id = ?1")
    List<City> findCityByUserId(Long userId);

    @Query("select c.country from City c where c.id = ?1")
    Country findCountryByCityId(Long cityId);

    @Query("select c from City c where c.country.id = ?1")
    List<City> findCityByCountryId(List<Country> country);
}
