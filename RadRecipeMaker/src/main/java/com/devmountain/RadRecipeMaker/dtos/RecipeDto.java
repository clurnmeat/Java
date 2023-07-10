package com.devmountain.RadRecipeMaker.dtos;

import com.devmountain.RadRecipeMaker.entities.Comment;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Serializable {
    private Long id;
    private String recipeName;

    private String recipeIngredients;

    private String recipe;

    private Set<Comment> commentSet = new HashSet<>();

    public RecipeDto(Recipe recipe){
        if(recipe.getId() != null){
            this.id = recipe.getId();
        }
        if(recipe.getRecipeName() != null){
            this.recipeName = recipe.getRecipeIngredients();
        }
        if(recipe.getCommentSet() != null){
            this.commentSet = recipe.getCommentSet();
        }
        if(recipe.getRecipe() != null){
            this.recipe = recipe.getRecipe();
        }
    }
    public RecipeDto(RecipeDto recipeDto){
        if(recipeDto.getRecipeName() != null){
            this.recipeName = recipeDto.getRecipeName();
        }
        if(recipeDto.getRecipe() != null){
            this.recipe = recipeDto.getRecipe();
        }
        if(recipeDto.getRecipeIngredients() != null){
            this.recipeIngredients = recipeDto.getRecipeIngredients();
        }
    }

}
