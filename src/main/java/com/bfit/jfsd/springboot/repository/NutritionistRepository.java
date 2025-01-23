package com.bfit.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bfit.jfsd.springboot.model.Nutritionist;

@Repository
public interface NutritionistRepository extends CrudRepository<Nutritionist, String> {
    @Query("select n from Nutritionist n where n.email = ?1 and n.password = ?2")
    public Nutritionist checkNutritionistLogin(String nemail, String npassword);
}
