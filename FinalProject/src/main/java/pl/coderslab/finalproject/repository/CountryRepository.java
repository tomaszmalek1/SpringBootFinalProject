package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.model.Country;

import java.util.List;


public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("select c from Country c where c.user.id = ?1")
    List<Country> findCountryByUserId(Long userId);
}
