package com.example.eserciziSpringBoot.esercizio6.controller;

import com.example.eserciziSpringBoot.esercizio6.entity.MealEntity;
import com.example.eserciziSpringBoot.esercizio6.service.MealService6;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/esercizio-6")
public class MealController6 {
    private MealService6 mealService;

    @Autowired
    public MealController6(MealService6 mealService) {
        this.mealService = mealService;
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<MealEntity>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PostMapping(value = "/post/meal")
    public ResponseEntity<String> addMeal (@RequestBody MealEntity meal) {
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping (value = "/delete/meal/{mealName}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String mealName) {
        try {
            mealService.deleteMeal(mealName);
            return ResponseEntity.ok("Meal deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in deletion");
        }
    }

    @GetMapping("/winter-meals")
    public ResponseEntity<List<MealEntity>> isWinterMeal() {
        return ResponseEntity.ok(mealService.getWinterMeals());
    }
}
