package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Place;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.repository.CountryRepository;
import pl.coderslab.finalproject.service.CityService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Controller
public class CityController {
    private final CityService cityService;
    private final CountryRepository countryRepository;

    public CityController(CityService cityService, CountryRepository countryRepository) {
        this.cityService = cityService;
        this.countryRepository = countryRepository;
    }

    @GetMapping("/app/addCity")
    public String addCityForm(Model model, HttpSession ses) {
        City city = new City();
        model.addAttribute("city", city);
        User user = (User) ses.getAttribute("userSession");
        model.addAttribute("allCountries", countryRepository.findCountryByUserId(user.getId()));
        return "app/userAddCity";
    }

    @PostMapping("/app/addCity")
    public String addCity(@Valid City city, BindingResult result, Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        if (result.hasErrors()) {
            model.addAttribute("allCountries", countryRepository.findCountryByUserId(user.getId()));
            return "app/userAddCity";
        } else if (city.getLastDate().isBefore(city.getFirstDate())) {
            model.addAttribute("dateMessage", "Podana data nie może być wcześniejsza niż " + city.getFirstDate());
            model.addAttribute("allCountries", countryRepository.findCountryByUserId(user.getId()));
            return "app/userAddCity";
        } else {
            cityService.add(city);
            return "redirect:/app/userHomePage";
        }
    }

    @GetMapping("app/cityDelete/{id}")
    public String deleteCity(@PathVariable long id) {
        if (!cityService.get(id).isEmpty()) {
            cityService.delete(id);
            return "redirect:/app/planList";
        }
        return "redirect:/app/planList";
    }

    @GetMapping("/app/cityDetails/{cityId}")
    public String cityDetails(@PathVariable Long cityId, Model model) {
        Optional<City> city = cityService.get(cityId);
        model.addAttribute("cityDetails", city);
        long between = ChronoUnit.DAYS.between(city.get().getFirstDate(), city.get().getLastDate());
        int oneDayFoodCost = (int) (city.get().getOneDayFoodCost() * between);
        int sleepingCost = (int) (city.get().getSleepingCost() * between);
        int arrivalCost = city.get().getArrivalCost();
        int placeCost = 0;
        List<Place> placeList = city.get().getPlaceList();
        for (Place place : placeList) {
            placeCost += place.getTicketCost();
        }
        int cityCost = oneDayFoodCost + sleepingCost + arrivalCost + placeCost;
        model.addAttribute("cityCost", cityCost);
        return "app/userCityDetails";
    }

    @GetMapping("app/cityUpdate/{id}")
    public String cityUpdateForm(@PathVariable long id, Model model) {
        model.addAttribute("cityUpdate", cityService.get(id));
        return "app/userCityUpdate";
    }

    @PostMapping("app/cityUpdate/{id}")
    public String cityUpdate(@ModelAttribute("cityUpdate") @Valid City city, BindingResult result, Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        if (result.hasErrors()) {
            return "app/userCityUpdate";
        } else if (city.getLastDate().isBefore(city.getFirstDate())) {
            model.addAttribute("dateMessage", "Podana data nie może być wcześniejsza niż " + city.getFirstDate());
            model.addAttribute("allCountries", countryRepository.findCountryByUserId(user.getId()));
            return "app/userCityUpdate";
        } else {
            cityService.add(city);
            return "redirect:/app/planList";
        }
    }
}
