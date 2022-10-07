package pl.coderslab.finalproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaCityService implements CityService {

    private final CityRepository cityRepository;

    public JpaCityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void add(City city) {
        cityRepository.save(city);
    }

    @Override
    public List<City> get() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Optional<City> get(Long id) {
        return cityRepository.findById(id);
    }

}
