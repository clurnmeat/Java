package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.entities.Recipe;
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


    @Transactional
    List<String> addComment(Long recipeId, CommentDto commentDto, Long userId);
    
    
}
