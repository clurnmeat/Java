package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface RecipeService {


    @Transactional
    List<String> addRecipe(RecipeDto recipeDto);


    void deleteRecipe(Long recipeId);


    void updateRecipe(RecipeDto recipeDto);
    

    @Transactional
    List<RecipeDto> getAllRecipesByRecipeId(long recipeId);

    @Transactional
    Optional<RecipeDto> getRecipeById(Long recipeId);


    String getRecipeByName(String recipeName);
}
