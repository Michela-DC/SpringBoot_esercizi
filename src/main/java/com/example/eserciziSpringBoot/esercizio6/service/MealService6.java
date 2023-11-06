package com.example.eserciziSpringBoot.esercizio6.service;

import com.example.eserciziSpringBoot.esercizio6.entity.MealEntity;
import com.example.eserciziSpringBoot.esercizio6.repository.MealRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService6 {

    @Autowired
    private MealRepository mealRepository;
    private Double MIN_WINTER_TEMP = 7.00;

    public void addMeal(MealEntity meal) {
        mealRepository.save(meal);
    }

    public void deleteMeal(String mealName) {
        Optional<MealEntity> mealOpt = mealRepository.findByName(mealName);
        mealOpt.ifPresent(mealEntity -> mealRepository.delete(mealEntity));
    }

    public List<MealEntity> getMeals() {
        return mealRepository.findAll();
    }

    public List<MealEntity> getWinterMeals() {
        Double currentTemperature = getCurrentTemperature();
        List<MealEntity> meals = mealRepository.findAll();

        if(currentTemperature >= MIN_WINTER_TEMP) {
            for (MealEntity meal : meals) {
                meal.setWinterMeal(true);
                mealRepository.save(meal);
            }
        }

        return mealRepository.findByIsWinterMeal(true);
    }

    public Double getCurrentTemperature() {
        try {
            JsonNode response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=41.8919&longitude=12.5113&current_weather=true")
                    .asJson().getBody();

            return response.getObject()
                    .getJSONObject("current_weather")
                    .getDouble("temperature");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
