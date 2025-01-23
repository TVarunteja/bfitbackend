package com.bfit.jfsd.springboot.controller;

import com.bfit.jfsd.springboot.model.DietPlan;
import com.bfit.jfsd.springboot.service.DietPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diet-plans")
public class DietPlanController {

    @Autowired
    private DietPlanService dietPlanService;

    // Endpoint to get all diet plans
    @GetMapping("/view")
    public ResponseEntity<List<DietPlan>> getAllDietPlans() {
        List<DietPlan> dietPlans = dietPlanService.getAllDietPlans();
        return ResponseEntity.ok(dietPlans);
    }

    // Endpoint to add a new diet plan
    @PostMapping("/add")
    public ResponseEntity<String> addDietPlan(@RequestBody DietPlan dietPlan) {
        try {
            dietPlanService.addDietPlan(dietPlan);
            return ResponseEntity.status(201).body("Diet plan added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add diet plan");
        }
    }
}