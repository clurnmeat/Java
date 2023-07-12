package com.devmountain.RadRecipeMaker.controllers;

import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import com.devmountain.RadRecipeMaker.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/addrecipe")
    public List<String> addRecipe(@RequestBody RecipeDto recipeDto){

        return recipeService.addRecipe(recipeDto);
    }

    @PostMapping("/{recipeId}")
    public RecipeDto listRecipe(@PathVariable Long recipeId){
        return recipeService.getRecipeById(recipeId).get();
    }

    @PostMapping("/{recipe_name}")
    public Optional<Recipe> searchByName(@PathVariable String recipe_name){
        return recipeService.getRecipeByName(recipe_name);
    }



}
