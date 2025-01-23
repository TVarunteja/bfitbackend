package com.bfit.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfit.jfsd.springboot.model.User;
import com.bfit.jfsd.springboot.model.Workout;
import com.bfit.jfsd.springboot.repository.UserRepository;
import com.bfit.jfsd.springboot.repository.WorkoutRepository;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WorkoutRepository workoutRepository;
	
	public String addUser(User u) 
	{
		userRepository.save(u);
		return "User Added Successfully";
	}

	@Override
	public User checkUserLogin(String eemail, String eepassword) {
		return userRepository.checkUserLogin(eemail, eepassword);
	}

	@Override
	public User viewUserById(int id) 
	{
		return userRepository.findById(id).get();
	}

	@Override
	public String updateUser(User u) 
	{
		Optional<User> obj = userRepository.findById(u.getId());
		
		User user = obj.get();
		user.setName(u.getName());
		user.setLocation(u.getLocation());
		user.setHeight(u.getHeight());
		user.setGoal_weight(u.getGoal_weight());
		user.setActual_weight(u.getActual_weight());
		user.setActivity_level(u.getActivity_level());
		
		user.setGoals(u.getGoals());
		user.setBarriers(u.getBarriers());
		
		
		
		
		
		userRepository.save(user);
		
		return "User Updated Successfully";
	}

	@Override
	public String addWorkout(Workout w) 
	{
		workoutRepository.save(w);
		return "Workout Added Successfully";
	}

	@Override
	public String viewworkoutbydateString(String date) 
	{
		
		return null;
	}

	@Override
	public List<Workout> viewallworkouts() 
	{
		
		return (List<Workout>) workoutRepository.findAll();
	}

	@Override
	public List<User> viewallusers() 
	{
		return (List<User>) userRepository.findAll();
	}

	@Override
	public String deleteUser(int id) 
	{
		
		Optional<User> obj = userRepository.findById(id);
		String msg = null;
		if(obj.isPresent())
		{
			User u = obj.get();
			userRepository.delete(u);
			msg = "User Deleted Successfully";
		}
		else
		{
			msg = "User ID not Found";
		}
		return msg;
	}
	
	
	 @Override
	    public int countTotalUsers() {
	        return (int) userRepository.count();
	    }
	

	
	

	

}
