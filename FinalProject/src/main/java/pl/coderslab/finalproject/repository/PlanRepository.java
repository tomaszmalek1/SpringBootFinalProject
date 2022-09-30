package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.model.Country;
import pl.coderslab.finalproject.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
