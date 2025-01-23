package com.bfit.jfsd.springboot.repository;

import com.bfit.jfsd.springboot.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, String> {
    // Custom queries can be added here if needed
	
	@Query("SELECT COUNT(u) FROM User u")
	 long countAllUsers();
	
	@Query("SELECT COUNT(n) FROM Nutritionist n")
	 long countAllNutristist();
	
	@Query("SELECT COUNT(w) FROM Workout w")
	 long countAllWorkouts();
}