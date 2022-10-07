package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.model.*;
import pl.coderslab.finalproject.repository.PlanRepository;
import pl.coderslab.finalproject.service.PlanService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class PlanController {

    private final PlanService planService;
    private PlanRepository planRepository;

    public PlanController(PlanService planService, PlanRepository planRepository) {
        this.planService = planService;
        this.planRepository = planRepository;
    }

    @GetMapping("/app/addPlan")
    public String addPlanForm(Model model) {
        model.addAttribute("plan", new Plan());
        return "app/userAddPlan";
    }

    @PostMapping("/app/addPlan")
    public String addPlan(@Valid Plan plan, BindingResult result, Model model, HttpSession ses) {
        if (result.hasErrors()) {
            return "app/userAddPlan";
        } else if (plan.getLastDate().isBefore(plan.getFirstDate())) {
            model.addAttribute("dateMessage", "Podana data nie może być wcześniejsza niż " + plan.getFirstDate());
            return "app/userAddPlan";
        } else {
            plan.setUser((User) ses.getAttribute("userSession"));
            planService.add(plan);
            return "redirect:/app/planList";
        }
    }

    @GetMapping("/app/userPlanDetails/{planId}")
    public String userPlanDetails(@PathVariable Long planId, Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        try {
            List<Plan> sortedPlans = planRepository.sortedPlanByDate(user.getId());
            int cityCost = 0;
            int placeCost = 0;
            for (Plan plan : sortedPlans) {
                if (plan.getId() == planId) {
                    model.addAttribute("planDetails", plan);
                    List<Country> countryList = plan.getCountryList();
                    for (Country country : countryList) {
                        List<City> cityList = country.getCityList();
                        for (City city : cityList) {
                            long between = ChronoUnit.DAYS.between(city.getFirstDate(), city.getLastDate());
                            cityCost += (city.getArrivalCost() + city.getSleepingCost() * between + city.getOneDayFoodCost() * between);
                            List<Place> placeList = city.getPlaceList();
                            for (Place place : placeList) {
                                placeCost += place.getTicketCost();
                            }
                        }
                    }
                }
            }
            int finalCost = placeCost + cityCost;
            model.addAttribute("finalCost", finalCost);
        } catch (IndexOutOfBoundsException e) {
            e.getMessage();
        }
        return "app/userPlanDetails";
    }

    @GetMapping("app/planList")
    public String planList(Model model, HttpSession ses) {
        User user = (User) ses.getAttribute("userSession");
        model.addAttribute("planList", planRepository.sortedPlanByDate(user.getId()));
        return "app/userPlanList";
    }

    @GetMapping("app/planDelete/{id}")
    public String planDelete(@PathVariable long id) {
        if (!planService.get(id).isEmpty()) {
            planService.delete(id);
            return "redirect:/app/planList";
        }
        return "redirect:/app/planList";
    }

    @GetMapping("app/planUpdate/{id}")
    public String planUpdateForm(@PathVariable long id, Model model) {
        if (!planService.get(id).isEmpty()) {
            model.addAttribute("planUpdate", planService.get(id));
            return "app/userPlanUpdate";
        }
        return "redirect:/app/planList";
    }

    @PostMapping("app/planUpdate/{id}")
    public String planUpdate(@ModelAttribute("planUpdate") @Valid Plan plan, BindingResult result, Model model, HttpSession ses) {
        if (result.hasErrors()) {
            return "app/userPlanUpdate";
        } else if (plan.getLastDate().isBefore(plan.getFirstDate())) {
            model.addAttribute("dateMessage", "Podana data nie może być wcześniejsza niż " + plan.getFirstDate());
            return "app/userAddPlan";
        } else {
            planService.add(plan);
            return "redirect:/app/planList";
        }
    }

    @GetMapping("app/addToPlan")
    public String addToPlan() {
        return "app/userAddToPlan";
    }
}
