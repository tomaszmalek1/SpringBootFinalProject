package pl.coderslab.finalproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaCountryService implements CountryService {
    private final CountryRepository countryRepository;

    public JpaCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void add(Country country) {
        countryRepository.save(country);
    }

    @Override
    public List<Country> get() {
        return countryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> get(Long id) {
        return countryRepository.findById(id);
    }
}
