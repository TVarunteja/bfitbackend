package com.bfit.jfsd.springboot.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int id;

    @Column(name = "uname", nullable = false, length = 50)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_goals", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "goal")
    private List<String> goals;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_barriers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "barrier")
    private List<String> barriers;

    @Column(name = "uactivity_level", nullable = false, length = 50)
    private String activity_level;

    @Column(name = "uheight", nullable = false)
    private int height;

    @Column(name = "uactual_weight", nullable = false)
    private int actual_weight;

    @Column(name = "ugoal_weight", nullable = false)
    private int goal_weight;

    @Column(name = "ugender", nullable = false, length = 10)
    private String gender;

    @Column(name = "udob", nullable = false)
    private LocalDate dob;

    @Column(name = "ulocation", nullable = false, length = 100)
    private String location;

    @Column(name = "uemail", nullable = false, unique = true, length = 100)
    private String email;    

    @Column(name = "upassword", nullable = false, unique = true, length = 100)
    private String password;
    
    

    // Default constructor
    public User() {
        // Initialize fields if needed
        this.activity_level = "default_activity_level";
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getGoals() {
		return goals;
	}

	public void setGoals(List<String> goals) {
		this.goals = goals;
	}

	public List<String> getBarriers() {
		return barriers;
	}

	public void setBarriers(List<String> barriers) {
		this.barriers = barriers;
	}

	public String getActivity_level() {
		return activity_level;
	}

	public void setActivity_level(String activity_level) {
		this.activity_level = activity_level;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getActual_weight() {
		return actual_weight;
	}

	public void setActual_weight(int actual_weight) {
		this.actual_weight = actual_weight;
	}

	public int getGoal_weight() {
		return goal_weight;
	}

	public void setGoal_weight(int goal_weight) {
		this.goal_weight = goal_weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    // Getters and setters for each field
    // ...
}
