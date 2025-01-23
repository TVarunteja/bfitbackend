package com.bfit.jfsd.springboot.model;

import java.io.InputStream;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "nutritionist_table")
public class Nutritionist {
    @Id
    private String email;

    // Personal Information
    private String fullName;
    private String phone;
    private String gender;
    private LocalDate dateOfBirth;
    
    // It's better to store the image as a path or URL
    @Lob
    @JsonIgnore
    private Blob profileImage; // Change Blob to String for image path/URL
    private String password = "bfit";

    // Professional Details
    @ElementCollection
    private List<String> qualifications;
    
    private int yearsOfExperience;
    private String licenseNumber;
    
    @ElementCollection
    private List<String> specializations;

    // Services & Consultation
    @ElementCollection
    private List<String> servicesOffered;
    
    private double consultationFee;
    
    @ElementCollection
    private List<String> consultationModes;
    
    @ElementCollection
    private List<String> languages;

    // Work Details
    private String clinicAddress;
    private String workingHours;
    
    @ElementCollection
    private List<String> availableDays;
    
    private String bio;

    // Social Media
    private String linkedInUrl;
    private String twitterUrl;

    // Constructor
    public Nutritionist() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<String> qualifications) {
		this.qualifications = qualifications;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public List<String> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(List<String> specializations) {
		this.specializations = specializations;
	}

	public List<String> getServicesOffered() {
		return servicesOffered;
	}

	public void setServicesOffered(List<String> servicesOffered) {
		this.servicesOffered = servicesOffered;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public List<String> getConsultationModes() {
		return consultationModes;
	}

	public void setConsultationModes(List<String> consultationModes) {
		this.consultationModes = consultationModes;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public List<String> getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(List<String> availableDays) {
		this.availableDays = availableDays;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	 public String getProfileImageBase64() {
	        if (this.profileImage != null) {
	            try (InputStream is = this.profileImage.getBinaryStream()) {
	                byte[] bytes = is.readAllBytes();
	                return Base64.getEncoder().encodeToString(bytes);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	    }

	public void setProfileImage(Blob profileImage) {
		this.profileImage = profileImage;
	}

    // Getters and Setters
    // ... (keep your existing getters and setters)
	
	
	
	
}