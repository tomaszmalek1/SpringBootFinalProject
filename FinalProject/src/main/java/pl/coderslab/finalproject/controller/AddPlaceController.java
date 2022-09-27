package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.Place;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.repository.CityRepository;
import pl.coderslab.finalproject.repository.CountryRepository;
import pl.coderslab.finalproject.service.CityService;
import pl.coderslab.finalproject.service.CountryService;
import pl.coderslab.finalproject.service.PlaceService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AddPlaceController {
    private final PlaceService placeService;
    private final CityService cityService;
    private final CountryService countryService;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public AddPlaceController(PlaceService placeService, CityService cityService, CountryService countryService, CountryRepository countryRepository, CityRepository cityRepository) {
        this.placeService = placeService;
        this.cityService = cityService;
        this.countryService = countryService;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/app/addPlace")
    public String addPlaceForm(Model model, HttpSession ses) {
        Place place = new Place();
        model.addAttribute("place", place);
        User user = (User) ses.getAttribute("userSession");
        model.addAttribute("allCities", cityRepository.findCityByUserId(user.getId()));
        return "app/userAddPlace";
    }

    @PostMapping("/app/addPlace")
    public String addCity(@Valid Place place, BindingResult result, HttpSession ses) {
        if (result.hasErrors()) {
            return "app/userAddPlace";
        }
        place.setUser((User) ses.getAttribute("userSession"));
        Country countryByCityId = cityRepository.findCountryByCityId(place.getCity().getId());
        place.setCountry(countryByCityId);
        placeService.add(place);
        return "redirect:/app/userHomePage";
    }
}
