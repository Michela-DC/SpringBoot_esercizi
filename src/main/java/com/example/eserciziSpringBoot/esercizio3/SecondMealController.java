package com.example.eserciziSpringBoot.esercizio3;
import com.example.eserciziSpringBoot.esercizio2.MealController;
import com.example.eserciziSpringBoot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/esercizio-3")
public class SecondMealController {

    private List<Meal> mealsList = new MealController().getMeals();

    @PostMapping ("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal) {
        mealsList.add(meal);

        return  ResponseEntity.ok("The meal has been added successfully");
    }

    @PutMapping("/meal/{name}")
    public Optional<Meal> updateMeal (@PathVariable String name, @RequestBody Meal updatedMeal) {
        Optional<Meal> opt = Optional.empty();

        for(Meal meal : mealsList) {
            if(meal.getName().equals(name)) {
                meal.setName(updatedMeal.getName());
                meal.setDescription(updatedMeal.getDescription());
                meal.setPrice(updatedMeal.getPrice());

                return Optional.of(meal);
            }
        }

        return opt;
    }

    @DeleteMapping("/meal/{name}")
    public List<Meal> deleteMealByName (@PathVariable String name) {

        for(Meal mealToRemove : mealsList) {
            if(mealToRemove.getName().equals(name)) {
                mealsList.remove(mealToRemove);
            }
        }

        return mealsList;
    }

    @DeleteMapping("/meal/price/{price}")
    public List<Meal> deleteMealsByPrice (@PathVariable Double price) {

        for(Meal mealToRemove : mealsList) {
            if(mealToRemove.getPrice() > price) {
                mealsList.remove(mealToRemove);
            }
        }

        return mealsList;
    }

    @PutMapping("/meal/{name}/price")
    public Optional<Meal> deleteMealsByPrice (@PathVariable String name, @RequestBody Double updatedPrice) {
        Optional<Meal> opt = Optional.empty();

        for(Meal meal : mealsList) {
            if(meal.getName().equals(name)) {
                meal.setPrice(updatedPrice);
                return Optional.of(meal);
            }
        }

        return opt;
    }

}
