package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"userSession"})
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/home/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        for (User user : userService.get()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                model.addAttribute("userSession", user);
                return "redirect:/app/userHomePage"; // widok dostępny po zalogowaniu
            }
        }
        model.addAttribute("message", "Bledny login lub haslo!");
        return "/home/login";
    }

    @GetMapping("/app/logout")
    public String logout(HttpSession ses) {
        ses.removeAttribute("userSession");
        return "redirect:/login";
    }
}
