package com.bfit.jfsd.springboot.service;

import java.util.List;

import com.bfit.jfsd.springboot.model.Nutritionist;

public interface NutritionistService 
{
	public Nutritionist checkNutritionistLogin(String nemail,String npassword);
	public List<Nutritionist> viewallnutrionists();
	public String deletenutrionist(String email);
	public Nutritionist viewNutritionistByEmail(String email);
}
