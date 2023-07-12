package com.devmountain.RadRecipeMaker.controllers;

import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.LongToIntFunction;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/addrecipe")
    public List<String> addRecipe(@RequestBody RecipeDto recipeDto){
        System.out.println(recipeDto);
        return recipeService.addRecipe(recipeDto);
    }

    @GetMapping("/{recipeId}")
    public Optional<RecipeDto> listRecipe(@PathVariable Long recipeId){
        return recipeService.getRecipeById(recipeId);
    }



}
