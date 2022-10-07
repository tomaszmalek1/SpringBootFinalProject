package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.model.Place;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.repository.CityRepository;
import pl.coderslab.finalproject.service.PlaceService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PlaceController {
    private final PlaceService placeService;
    private final CityRepository cityRepository;


    public PlaceController(PlaceService placeService, CityRepository cityRepository) {
        this.placeService = placeService;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/app/addPlace")
    public String addPlaceForm(Model model, HttpSession ses) {
        Place place = new Place();
        model.addAttribute("place", place);
        User user = (User) ses.getAttribute("userSession");
        model.addAttribute("allCities", cityRepository.findCitiesByUserId(user.getId()));
        return "app/userAddPlace";
    }

    @PostMapping("/app/addPlace")
    public String addPlace(@Valid Place place, BindingResult result, Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        if (result.hasErrors()) {
            model.addAttribute("allCities", cityRepository.findCitiesByUserId(user.getId()));
            return "app/userAddPlace";
        }
        placeService.add(place);
        return "redirect:/app/userHomePage";
    }

    @GetMapping("app/placeDelete/{id}")
    public String deletePlace(@PathVariable long id) {
        if (placeService.get(id).isEmpty()) {
            placeService.delete(id);
            return "redirect:/app/planList";
        }
        return "redirect:/app/planList";
    }

    @GetMapping("/app/placeDetails/{placeId}")
    public String placeDetails(@PathVariable Long placeId, Model model) {
        Optional<Place> place = placeService.get(placeId);
        model.addAttribute("placeDetails", place);
        return "app/userPlaceDetails";
    }

    @GetMapping("app/placeUpdate/{id}")
    public String placeUpdateForm(@PathVariable long id, Model model) {
        model.addAttribute("placeUpdate", placeService.get(id));
        return "app/userPlaceUpdate";
    }

    @PostMapping("app/placeUpdate/{id}")
    public String placeUpdate(@ModelAttribute("placeUpdate") @Valid Place place, BindingResult result) {
        if (result.hasErrors()) {
            return "app/userPlaceUpdate";
        }
        placeService.add(place);
        return "redirect:/app/planList";
    }
}
