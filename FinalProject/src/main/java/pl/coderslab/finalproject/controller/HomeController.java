package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.model.*;
import pl.coderslab.finalproject.repository.PlanRepository;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class HomeController {
    private final PlanRepository planRepository;

    public HomeController(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }


    @RequestMapping("/home")
    public String showHomePage() {
        return "/home/home";
    }

    @GetMapping("/app/userHomePage")
    public String userHomePageView(Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        try {
            List<Plan> sortedPlans = planRepository.sortedPlanByDate(user.getId());
            Plan firstPlan = sortedPlans.get(0);
            model.addAttribute("firstPlan", firstPlan);

            long daysToTrip = ChronoUnit.DAYS.between(LocalDate.now(), firstPlan.getFirstDate());
            model.addAttribute("daysToTrip", daysToTrip);

            List<Country> countryListFirstPlan = firstPlan.getCountryList();
            int cityCost = 0;
            int placeCost = 0;
            for (Country country : countryListFirstPlan) {
                List<City> cityListFirstPlan = country.getCityList();
                for (City city : cityListFirstPlan) {
                    long between = ChronoUnit.DAYS.between(city.getFirstDate(), city.getLastDate());
                    cityCost += (city.getArrivalCost() + (city.getSleepingCost()*between) + (city.getOneDayFoodCost()*between));
                    List<Place> placeListFirstPlan = city.getPlaceList();
                    for (Place p : placeListFirstPlan) {
                        placeCost += p.getTicketCost();
                    }
                }
            }
            int finalCost = placeCost + cityCost;
            model.addAttribute("finalCost", finalCost);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            model.addAttribute("planException", "Brak");
            e.getMessage();
        }
        return "app/userHomePage";
    }
}
