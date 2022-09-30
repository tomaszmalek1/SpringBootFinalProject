package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.model.City;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.Plan;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.repository.CityRepository;
import pl.coderslab.finalproject.repository.CountryRepository;
import pl.coderslab.finalproject.repository.PlaceRepository;
import pl.coderslab.finalproject.repository.PlanRepository;
import pl.coderslab.finalproject.service.CityService;
import pl.coderslab.finalproject.service.PlanService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AddPlanController {

    private final PlanService planService;
    private final CountryRepository countryRepository;
    private final CityService cityService;

    private CityRepository  cityRepository;
    private PlaceRepository placeRepository;

    public AddPlanController(PlanService planService, CountryRepository countryRepository, CityService cityService) {
        this.planService = planService;
        this.countryRepository = countryRepository;
        this.cityService = cityService;
    }

    @GetMapping("/app/addPlan")
    public String addPlanForm(Model model) {
        model.addAttribute("plan", new Plan());
        return "app/userAddPlan";
    }

    @PostMapping("/app/addPlan")
    public String addPlan(@Valid Plan plan, BindingResult result, HttpSession ses) {
        if (result.hasErrors()) {
            return "app/userAddPlan";
        }
        planService.add(plan);
        return "redirect:/app/userHomePage";
    }
}
