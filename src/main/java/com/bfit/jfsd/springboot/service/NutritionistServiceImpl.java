package com.bfit.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfit.jfsd.springboot.model.Nutritionist;
import com.bfit.jfsd.springboot.model.User;
import com.bfit.jfsd.springboot.repository.NutritionistRepository;

@Service
public class NutritionistServiceImpl implements NutritionistService
{

	@Autowired
	NutritionistRepository nutritionistRepository;
	
	public Nutritionist checkNutritionistLogin(String nemail, String npassword) 
	{
		
		return nutritionistRepository.checkNutritionistLogin(nemail, npassword);
	}

	@Override
	public List<Nutritionist> viewallnutrionists() 
	{
		// TODO Auto-generated method stub
		return (List<Nutritionist>) nutritionistRepository.findAll();
	}

	@Override
	public String deletenutrionist(String email) {
		Optional<Nutritionist> obj = nutritionistRepository.findById(email);
		String msg = null;
		if(obj.isPresent())
		{
			Nutritionist u = obj.get();
			nutritionistRepository.delete(u);
			msg = "Nutritionist Deleted Successfully";
		}
		else
		{
			msg = "Nutritionist ID not Found";
		}
		return msg;
	}

	@Override
	public Nutritionist viewNutritionistByEmail(String email) 
	{
		
		return nutritionistRepository.findById(email).get();
	}

}
