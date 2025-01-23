// FoodGoal.java
package com.bfit.jfsd.springboot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class FoodGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique ID for each FoodGoal entry

    private String date;  // Date for the food goal

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "food_goal_id")  // Foreign key to link the meals to the food goal
    private List<Meal> meals;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    // Meal and FoodItem classes are nested below
    @Entity
    public static class Meal {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String mealName;  // Meal type (e.g., breakfast, lunch)

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "meal_id")
        private List<FoodItem> foodItems;

        private double totalQuantity;  // Total quantity for the meal
        private double totalProtein;  // Total protein for the meal

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMealName() {
            return mealName;
        }

        public void setMealName(String mealName) {
            this.mealName = mealName;
        }

        public List<FoodItem> getFoodItems() {
            return foodItems;
        }

        public void setFoodItems(List<FoodItem> foodItems) {
            this.foodItems = foodItems;
        }

        public double getTotalQuantity() {
            return totalQuantity;
        }

        public void setTotalQuantity(double totalQuantity) {
            this.totalQuantity = totalQuantity;
        }

        public double getTotalProtein() {
            return totalProtein;
        }

        public void setTotalProtein(double totalProtein) {
            this.totalProtein = totalProtein;
        }
    }

    @Entity
    public static class FoodItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private double quantity;
        private double protein;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public double getProtein() {
            return protein;
        }

        public void setProtein(double protein) {
            this.protein = protein;
        }
    }
}