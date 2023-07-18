package com.devmountain.RadRecipeMaker.services;


import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import com.devmountain.RadRecipeMaker.repositories.RecipeRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CommentService commentRepository;

    @Autowired
    private UserService userService;



    @Override
    @Transactional
    public List<String> addRecipe(RecipeDto recipeDto){
        List<String> response = new ArrayList<>();
        Recipe recipe = new Recipe(recipeDto);
        recipeRepository.saveAndFlush(recipe);
        response.add("Recipe added Successfully");
        return response;
    }

    @Override
    @Transactional
    public void deleteRecipe(Long recipeId){
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        recipeOptional.ifPresent(recipe -> recipeRepository.delete(recipe));
    }

    @Override
    @Transactional
    public void updateRecipe(@NotNull RecipeDto recipeDto){
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeDto.getId());
        recipeOptional.ifPresent(recipe -> {
            recipe.setRecipe(recipeDto.getRecipe());
            recipeRepository.saveAndFlush(recipe);
        });
    }



    @Override
    @Transactional
    public List<RecipeDto> getAllRecipesByRecipeId(long recipeId){
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(recipeOptional.isPresent()){
            List<Recipe> recipeList = recipeRepository.findAllById((Iterable<Long>) recipeOptional.get());
            return recipeList.stream().map(recipe -> new RecipeDto(recipe)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public Optional<RecipeDto> getRecipeById(Long recipeId){
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(recipeOptional.isPresent()){
            return Optional.of(new RecipeDto(recipeOptional.get()));
        }
        return Optional.empty();
    }


    @Override
    @Transactional
    public List<String> addComment(Long recipeId, CommentDto commentDto, Long user_id){
        List<String> response = new ArrayList<>();
        List<String> commentList = commentRepository.addComment(commentDto, recipeId, user_id);
        response.add("Comment Added!");
        return response;
    }

    @Override
    @Transactional
    public Recipe getRecipeByName(RecipeDto recipeDto) {
        Optional<Recipe> recipeOptional = recipeRepository.findByRecipeName(recipeDto);
        if(recipeOptional.isPresent()){
            return recipeOptional.get();
        } else {
            return null;
        }

    }

   
}
