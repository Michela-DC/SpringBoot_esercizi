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
        if (ingredientDao.existsById(ingredientId)) {
            updateIngredient.setId(ingredientId);
        }

        return Optional.of(updateIngredient);
    }

    public void deleteIngredientById(Long id) {
        ingredientDao.deleteById(id);
    }
}

