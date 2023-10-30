package com.example.eserciziSpringBoot.esercizio5.controller;

import com.example.eserciziSpringBoot.esercizio5.entity.Ingredient;
import com.example.eserciziSpringBoot.esercizio5.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getIngredients() {
        List<Ingredient> ingredients = ingredientService.findAllIngredients();

        if(!ingredients.isEmpty()) {
            //return new ResponseEntity<>(ingredients, HttpStatus.OK);
            return ResponseEntity.ok(ingredients);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Ingredient> insertIngredient(@RequestBody Ingredient ingredientToInsert) {
        Ingredient ingredient = ingredientService.insertIngredient(ingredientToInsert);

        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIngredientById (@PathVariable Long id) {
        try {
            ingredientService.deleteIngredientById(id);
            return ResponseEntity.ok("Ingredient with id = " + id + " successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in deletion");
        }
    }
}
