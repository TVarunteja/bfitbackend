package com.bfit.jfsd.springboot.service;

import com.bfit.jfsd.springboot.model.FoodGoal;

public interface FoodGoalService 
{
	FoodGoal saveFoodGoal(FoodGoal foodGoal);

    FoodGoal getFoodGoalByDate(String date);
	
}
