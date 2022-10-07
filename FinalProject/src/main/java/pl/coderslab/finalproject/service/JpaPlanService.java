package pl.coderslab.finalproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.model.Plan;
import pl.coderslab.finalproject.repository.PlanRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaPlanService implements PlanService {
    private final PlanRepository planRepository;

    public JpaPlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public void add(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public List<Plan> get() {
        return planRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public Optional<Plan> get(Long id) {
        return planRepository.findById(id);
    }

}
