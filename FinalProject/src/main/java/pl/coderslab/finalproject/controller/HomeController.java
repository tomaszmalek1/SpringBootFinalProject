package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.finalproject.service.CityService;


@Controller
public class HomeController {

    private final CityService cityService;

    public HomeController(CityService cityService) {
        this.cityService = cityService;
    }


    @RequestMapping("/home")
    public String showHomePage() {
        return "/home/home";
    }

    @GetMapping("/app/userHomePage")
    public String userHomePageView() {
        return "app/userHomePage";
    }



}
