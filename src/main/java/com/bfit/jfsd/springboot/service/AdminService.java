package com.bfit.jfsd.springboot.service;

import com.bfit.jfsd.springboot.model.Admin;
import com.bfit.jfsd.springboot.model.Nutritionist;

public interface AdminService {
    Admin adminLogin(String username, String password);
    Admin getAdmin();
    String addNutrionist(Nutritionist n);
    
    public long getUserCount();
    
    public long getNutritionistCount();
    
    public long getWorkoutCount();
}