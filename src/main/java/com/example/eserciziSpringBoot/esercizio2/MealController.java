package com.example.eserciziSpringBoot.esercizio2;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/esercizio-2")
public class MealController {
    private List<Meal> mealsList = new ArrayList<>();

    @GetMapping("/meals")
    public List<Meal> getMeals() {
        Meal meal1 = new Meal("carbonara", "tipico piatto romano", 12.35);
        Meal meal2 = new Meal("amatriciana", "tipico piatto di Amatrice", 11.80);
        Meal meal3 = new Meal("troffie al pesto", "tipico piatto ligure", 10.75);

        mealsList.add(meal1);
        mealsList.add(meal2);
        mealsList.add(meal3);

        return mealsList;
    }

    @GetMapping("/meal/{name}")
    public Optional<Meal> getMealByName(@PathVariable String name) {
        Optional<Meal> opt = Optional.empty();

        for(Meal meal : getMeals()) {
            if(name.equals(meal.getName()))  {
               return Optional.of(meal);
            }
        }

        return opt;
    }

    @GetMapping("/meal/description-match/{phrase}")
    public Optional<Meal> getMealByDescription(@PathVariable String phrase) {
        Optional<Meal> opt = Optional.empty();

        for(Meal meal : getMeals()) {
            if(meal.getDescription().contains(phrase))  {
                return Optional.of(meal);
            }
        }

        return opt;
    }

    @GetMapping("/meal/price")
    public List<Meal> getMealByPrice(@RequestParam Double min, @RequestParam Double max) {
        List<Meal> mealsByPrice = new ArrayList<>();

        for(Meal meal : getMeals()) {
            if(meal.getPrice() > min && meal.getPrice() < max)  {
                mealsByPrice.add(meal);
            }
        }

        return mealsByPrice;
    }

}
