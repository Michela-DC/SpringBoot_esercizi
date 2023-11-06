package com.example.eserciziSpringBoot.esercizio6.repository;

import com.example.eserciziSpringBoot.esercizio6.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {
    List<MealEntity> findByIsWinterMeal(boolean isWinterMeal);
    Optional<MealEntity> findByName(String mealName);
}
