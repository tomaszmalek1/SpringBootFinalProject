package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.service.CountryService;
import pl.coderslab.finalproject.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistryController {
    private final UserService userService;

    public RegistryController(UserService userService, CountryService countryService) {
        this.userService = userService;
    }
    @GetMapping("/registry")
    public String showRegistryForm(Model model) {
        model.addAttribute("user", new User());
        return "home/registry";
    }

    @PostMapping("/registry")
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "home/registry";
        }
        userService.add(user);
        return "redirect:/login";
    }
}
