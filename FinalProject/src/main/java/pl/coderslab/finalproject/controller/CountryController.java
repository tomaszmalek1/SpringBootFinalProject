package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.repository.PlanRepository;
import pl.coderslab.finalproject.service.CountryService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CountryController {
    private final CountryService countryService;
    private final PlanRepository planRepository;

    public CountryController(CountryService countryService, PlanRepository planRepository) {
        this.countryService = countryService;
        this.planRepository = planRepository;
    }

    @GetMapping("/app/addCountry")
    public String addCountryForm(Model model, HttpSession ses) {
        Country country = new Country();
        model.addAttribute("country", country);
        User user = (User) ses.getAttribute("userSession");
        model.addAttribute("planList", planRepository.findPlanByUserId(user.getId()));
        return "/app/userAddCountry";
    }

    @PostMapping("/app/addCountry")
    public String addCountry(@Valid Country country, BindingResult result, Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        if (result.hasErrors()) {
            model.addAttribute("planList", planRepository.findPlanByUserId(user.getId()));
            return "app/userAddCountry";
        }
        countryService.add(country);
        return "redirect:/app/userHomePage";
    }

    @GetMapping("app/countryDelete/{id}")
    public String deleteCountry(@PathVariable long id) {
        if (!countryService.get(id).isEmpty()) {
            countryService.delete(id);
            return "redirect:/app/planList";
        }
        return "redirect:/app/planList";
    }

    @GetMapping("app/countryUpdate/{id}")
    public String countryUpdateForm(@PathVariable long id, Model model, HttpSession ses) {
        model.addAttribute("countryUpdate", countryService.get(id));
        User user = (User) ses.getAttribute("userSession");
        model.addAttribute("planList", planRepository.findPlanByUserId(user.getId()));
        return "app/userCountryUpdate";
    }

    @PostMapping("app/countryUpdate/{id}")
    public String countryUpdate(@ModelAttribute("countryUpdate") @Valid Country country, BindingResult result, Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        if (result.hasErrors()) {
            model.addAttribute("planList", planRepository.findPlanByUserId(user.getId()));
            return "app/userCountryUpdate";
        }
        countryService.add(country);
        return "redirect:/app/planList";
    }

}
