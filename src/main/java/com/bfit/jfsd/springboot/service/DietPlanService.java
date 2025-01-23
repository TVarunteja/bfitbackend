package com.bfit.jfsd.springboot.service;

import com.bfit.jfsd.springboot.model.DietPlan;
import java.util.List;

public interface DietPlanService {

    // Method to get all diet plans
    List<DietPlan> getAllDietPlans();

    // Method to add a new diet plan
    DietPlan addDietPlan(DietPlan dietPlan);
}