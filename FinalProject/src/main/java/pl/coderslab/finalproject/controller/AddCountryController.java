package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.service.CountryService;
import pl.coderslab.finalproject.service.UserService;
import pl.coderslab.finalproject.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes({"countrySession"})
public class AddCountryController {
    private final CountryService countryService;

    public AddCountryController(UserService userService, CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/app/addCountry")
    public String CountryForm(Model model) {
        Country country = new Country();
        model.addAttribute("country", country);
        return "/app/userAddCountry";
    }

    @PostMapping("/app/addCountry")
    public String addCountry(@Valid Country country, BindingResult result, HttpSession ses, Model model) {
        if (result.hasErrors()) {
            return "app/userAddCountry";
        }
        country.setUser((User) ses.getAttribute("userSession"));
        countryService.add(country);
        model.addAttribute("countrySession", country);
        return "redirect:/app/userHomePage";
    }

}
