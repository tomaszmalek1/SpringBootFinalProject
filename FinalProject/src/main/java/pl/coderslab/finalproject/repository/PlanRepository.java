package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    @Query("select p from Plan p where p.user.id = ?1")
    List<Plan> findPlanByUserId(Long userId);

    @Query("select p from Plan p where p.user.id = ?1 order by p.firstDate ASC")
    List<Plan> sortedPlanByDate(Long userId);
}
