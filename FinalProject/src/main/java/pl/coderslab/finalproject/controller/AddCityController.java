package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.repository.CountryRepository;
import pl.coderslab.finalproject.service.CityService;
import pl.coderslab.finalproject.service.CountryService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AddCityController {
    private final CityService cityService;
    private final CountryService countryService;
    private final CountryRepository countryRepository;

    public AddCityController(CityService cityService, CountryService countryService, CountryRepository countryRepository) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.countryRepository = countryRepository;
    }

    @GetMapping("/app/addCity")
    public String addCountryDetails(Model model, HttpSession ses) {
        City city = new City();
        model.addAttribute("city", city);
        User user = (User) ses.getAttribute("userSession");
        model.addAttribute("allCountries", countryRepository.findCountryByUserId(user.getId()));
        return "app/userAddCity";
    }

    @PostMapping("/app/addCity")
    public String addCity(@Valid City city, BindingResult result, HttpSession ses) {
        if (result.hasErrors()) {
            return "app/userAddCity";
        }
        city.setUser((User) ses.getAttribute("userSession"));
        cityService.add(city);
        return "redirect:/app/userHomePage";
    }
}
