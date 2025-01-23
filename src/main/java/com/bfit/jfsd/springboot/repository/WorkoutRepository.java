package com.bfit.jfsd.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.bfit.jfsd.springboot.model.Workout;
import java.util.List;


public interface WorkoutRepository extends CrudRepository<Workout, Integer>
{
	
	List<Workout> findByDate(String date);
}
