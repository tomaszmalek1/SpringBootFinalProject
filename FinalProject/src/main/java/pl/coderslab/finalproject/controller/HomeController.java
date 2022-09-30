package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.finalproject.service.CityService;
import pl.coderslab.finalproject.service.PlaceService;
import pl.coderslab.finalproject.service.PlanService;


@Controller
public class HomeController {

    private final CityService cityService;
    private final PlanService planService;
    private final PlaceService placeService;

    public HomeController(CityService cityService, PlanService planService, PlaceService placeService) {
        this.cityService = cityService;
        this.planService = planService;
        this.placeService = placeService;
    }


    @RequestMapping("/home")
    public String showHomePage() {
        return "/home/home";
    }

    @GetMapping("/app/userHomePage")
    public String userHomePageView(Model model) {
        model.addAttribute("lastPlan");
        return "app/userHomePage";
    }



}
