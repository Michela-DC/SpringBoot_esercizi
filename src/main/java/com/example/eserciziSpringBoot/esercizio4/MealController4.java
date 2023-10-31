package com.example.eserciziSpringBoot.esercizio4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esercizio-4")
public class MealController4 {
    private MealService mealService;

    @Autowired
    public MealController4(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PostMapping(value = "/post/meal")
    public ResponseEntity<String> addMeal (@RequestBody Meal meal) {
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping (value = "/delete/meal/{mealNane} ")
    public ResponseEntity<String> deleteMealByName(@PathVariable String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted!");
    }
}
