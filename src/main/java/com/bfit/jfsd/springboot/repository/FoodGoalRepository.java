// UserRepository.java
package com.bfit.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bfit.jfsd.springboot.model.FoodGoal;


@Repository
public interface FoodGoalRepository extends JpaRepository<FoodGoal, Long> {
    FoodGoal findByDate(String date);
}