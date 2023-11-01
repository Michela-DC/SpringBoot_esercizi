package com.example.eserciziSpringBoot.esercizio5.service;

import com.example.eserciziSpringBoot.esercizio4.MealDao;
import com.example.eserciziSpringBoot.esercizio5.entity.Ingredient;
import com.example.eserciziSpringBoot.esercizio5.repository.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

//    private List<Ingredient> ingredients = new ArrayList<>();
    private IngredientDao ingredientDao;

    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public List<Ingredient> findAllIngredients() {
        return ingredientDao.findAll();
    }

    public Ingredient insertIngredient(Ingredient ingredient) {
        return ingredientDao.save(ingredient);
    }

    public Optional<Ingredient> updateIngredient(Long ingredientId, Ingredient updateIngredient) {
        Optional<Ingredient> ingredientOpt = ingredientDao.findById(ingredientId);

        if(!ingredientOpt.isEmpty()) {
            Ingredient ingredient = ingredientOpt.get();

            ingredient.setName(updateIngredient.getName());
            ingredient.setVegetarian(updateIngredient.isVegetarian());
            ingredient.setVegan(updateIngredient.isVegan());
            ingredient.setGlutenFree(updateIngredient.isGlutenFree());
            ingredient.setLactoseFree(updateIngredient.isLactoseFree());

            return Optional.of(ingredient);
        } else {
            return Optional.empty();
        }
    }

    public void deleteIngredientById(Long id) {
        ingredientDao.deleteById(id);
    }
}

