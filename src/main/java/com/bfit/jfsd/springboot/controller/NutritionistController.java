package com.bfit.jfsd.springboot.controller;

import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfit.jfsd.springboot.model.Nutritionist;
import com.bfit.jfsd.springboot.service.NutritionistService;

@RestController
@RequestMapping("/nutritionist")
public class NutritionistController {
    @Autowired
    NutritionistService nutritionistService;

    @GetMapping("/checknutrionistlogin")
    public Nutritionist checkUserLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        Nutritionist n = nutritionistService.checkNutritionistLogin(email, password);
        return n != null ? n : null;
    }

    @GetMapping("/viewallnutritionists")
    public List<Nutritionist> viewAllNutritionists() {
        return nutritionistService.viewallnutrionists();
    }

    @DeleteMapping("/deletenutritionist")
    public String deleteNutritionist(@RequestParam("email") String email) {
        return nutritionistService.deletenutrionist(email);
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> getNutritionistImage(@RequestParam String email) {
        Nutritionist nutritionist = nutritionistService.viewNutritionistByEmail(email);
        if (nutritionist == null || nutritionist.getProfileImageBase64() == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            byte[] imageBytes = Base64.getDecoder().decode(nutritionist.getProfileImageBase64());
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Assuming the image is JPEG
                    .body(imageBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    
    @GetMapping("/view")
    public ResponseEntity<Nutritionist> getNutritionistByEmail(@RequestParam String email) {
        try {
            Nutritionist nutritionist = nutritionistService.viewNutritionistByEmail(email);
            return ResponseEntity.ok(nutritionist);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    
    
    
    
    
}
