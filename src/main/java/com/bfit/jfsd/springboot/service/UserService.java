package com.bfit.jfsd.springboot.service;

import java.util.List;

import com.bfit.jfsd.springboot.model.User;
import com.bfit.jfsd.springboot.model.Workout;

public interface UserService 
{
	public String addUser(User u);
	public User checkUserLogin(String eemail,String eepassword);
	public User viewUserById(int id);
	public String updateUser(User u); 
	
	public String addWorkout(Workout w);
	public String viewworkoutbydateString(String date);
	public List<Workout> viewallworkouts();
	
	public List<User> viewallusers();
	
	public String deleteUser(int id);
	
	 int countTotalUsers();

	
	
}
