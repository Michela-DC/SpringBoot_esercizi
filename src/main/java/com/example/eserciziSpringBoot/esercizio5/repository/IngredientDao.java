package com.example.eserciziSpringBoot.esercizio5.repository;

import com.example.eserciziSpringBoot.esercizio5.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {}
