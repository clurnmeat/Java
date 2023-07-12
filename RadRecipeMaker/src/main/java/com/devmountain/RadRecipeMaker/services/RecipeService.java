package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RecipeService {


    @Transactional
    List<String> addRecipe(RecipeDto recipeDto);


    void deleteRecipe(Long recipeId);


    void updateRecipe(RecipeDto recipeDto);

    List<RecipeDto> getAllRecipesByRecipeId(Long recipeId);
   @Transactional
    Optional<RecipeDto> getRecipeById(Long recipeId);


    @Transactional
    Optional<Recipe> getRecipeByName(String recipeDto);
}
