package com.bfit.jfsd.springboot.controller;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bfit.jfsd.springboot.model.Admin;
import com.bfit.jfsd.springboot.model.Nutritionist;
import com.bfit.jfsd.springboot.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    

    @PostMapping(value = "/add-nutritionist", consumes = "multipart/form-data")
    public String addNutritionist(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("dob") String dob,
            @RequestParam("gender") String gender,
            @RequestParam("profileImage") MultipartFile profileImage,
            @RequestParam("qualifications") List<String> qualifications,
            @RequestParam("experience") Integer experience,
            @RequestParam("licenseNumber") String licenseNumber,
            @RequestParam("specializations") List<String> specializations,
            @RequestParam("servicesOffered") List<String> servicesOffered,
            @RequestParam("consultationFee") Double consultationFee,
            @RequestParam("consultationModes") List<String> consultationModes,
            @RequestParam("languages") List<String> languages,
            @RequestParam("clinicAddress") String clinicAddress,
            @RequestParam("workingHours") String workingHours,
            @RequestParam("availableDays") List<String> availableDays,
            @RequestParam("bio") String bio,
            @RequestParam("linkedin") String linkedin,
            @RequestParam("twitter") String twitter) throws Exception {

        // Convert profile image to Blob
        Blob profileImageBlob = null;
        if (!profileImage.isEmpty()) {
            byte[] bytes = profileImage.getBytes();
            profileImageBlob = new javax.sql.rowset.serial.SerialBlob(bytes);
        }

        Nutritionist nutritionist = new Nutritionist();
        nutritionist.setFullName(fullName);
        nutritionist.setEmail(email);
        nutritionist.setPhone(phone);
        nutritionist.setDateOfBirth(LocalDate.parse(dob));
        nutritionist.setGender(gender);
        nutritionist.setQualifications(qualifications);
        nutritionist.setYearsOfExperience(experience);
        nutritionist.setLicenseNumber(licenseNumber);
        nutritionist.setSpecializations(specializations);
        nutritionist.setServicesOffered(servicesOffered);
        nutritionist.setConsultationFee(consultationFee);
        nutritionist.setConsultationModes(consultationModes);
        nutritionist.setLanguages(languages);
        nutritionist.setClinicAddress(clinicAddress);
        nutritionist.setWorkingHours(workingHours);
        nutritionist.setAvailableDays(availableDays);
        nutritionist.setBio(bio);
        nutritionist.setLinkedInUrl(linkedin);
        nutritionist.setTwitterUrl(twitter);

        // Set the profile image Blob
        if (profileImageBlob != null) {
            nutritionist.setProfileImage(profileImageBlob);
        }

        return adminService.addNutrionist(nutritionist);
    }
    // Admin Login
    @GetMapping("/login")
    public ResponseEntity<Object> adminLogin(@RequestParam("email") String username,
                                              @RequestParam("password") String password) {
        // Check if credentials are valid for admin login
        Admin admin = adminService.adminLogin(username, password);

        if (admin != null) {
            // Return a successful login response with the admin data
            return ResponseEntity.ok(new LoginResponse("Login successful", admin));
        } else {
            // Return error response if login failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Invalid credentials"));
        }
    }

    // View admin details (Since there's only one admin, it's a fixed username)
    @GetMapping("/view")
    public ResponseEntity<Admin> viewAdmin() {
        Admin admin = adminService.getAdmin();

        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    // Response model for success
    public static class LoginResponse {
        private String message;
        private Admin admin;

        public LoginResponse(String message, Admin admin) {
            this.message = message;
            this.admin = admin;
        }

        public String getMessage() {
            return message;
        }

        public Admin getAdmin() {
            return admin;
        }
    }

    // Response model for error
    public static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getUserStats() {
        long totalClients = adminService.getUserCount();
        long totalNutristionist = adminService.getNutritionistCount();
        long totalWorkout = adminService.getWorkoutCount();

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalClients", totalClients);
        stats.put("totalNutristionist", totalNutristionist);
        stats.put("totalWorkout", totalWorkout);

        return ResponseEntity.ok(stats);
    }


}