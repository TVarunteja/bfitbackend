package com.bfit.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfit.jfsd.springboot.model.FoodGoal;
import com.bfit.jfsd.springboot.repository.FoodGoalRepository;

@Service
public class FoodGoalServiceImpl implements FoodGoalService
{
	  	@Autowired
	    private FoodGoalRepository repository;

	    @Override
	    public FoodGoal saveFoodGoal(FoodGoal foodGoal) 
	    {
	        return repository.save(foodGoal);
	    }

	    @Override
	    public FoodGoal getFoodGoalByDate(String date) {
	        return repository.findByDate(date);
	    }
	
}
