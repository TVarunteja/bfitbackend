package com.bfit.jfsd.springboot.service;

import com.bfit.jfsd.springboot.model.DietPlan;
import com.bfit.jfsd.springboot.repository.DietPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietPlanServiceImpl implements DietPlanService {

    @Autowired
    private DietPlanRepository dietPlanRepository;

    // Implement the method to get all diet plans
    @Override
    public List<DietPlan> getAllDietPlans() {
        return dietPlanRepository.findAll();
    }

    // Implement the method to add a new diet plan
    @Override
    public DietPlan addDietPlan(DietPlan dietPlan) {
        return dietPlanRepository.save(dietPlan);
    }
}