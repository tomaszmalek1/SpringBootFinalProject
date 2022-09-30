package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.Place;
import pl.coderslab.finalproject.model.Plan;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    void add(Plan plan);

    List<Plan> get();

    void delete(Long id);

    Optional<Plan> get(Long id);
}
