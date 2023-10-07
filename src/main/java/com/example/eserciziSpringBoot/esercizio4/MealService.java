package com.example.eserciziSpringBoot.esercizio4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal) {
        if(meal == null) throw new IllegalArgumentException("Meal can't be null");
        if(meal.getName() == null || meal.getDescription() == null || meal.getPrice() == 0) throw new IllegalArgumentException("All fields are required");
        mealDao.addMeal(meal);
    }

    public void deleteMeal(String mealName) {
        mealDao.deleteMeal(mealName);
    }

    public void updateMeal (Meal meal) {
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeals() {
        return mealDao.getMeals();
    }
}
