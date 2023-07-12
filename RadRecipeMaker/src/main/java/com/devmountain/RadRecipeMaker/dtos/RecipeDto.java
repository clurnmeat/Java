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
        } else if(recipe.getRecipeName() != null){
            this.recipeName = recipe.getRecipeIngredients();
        } else if(recipe.getCommentSet() != null){
            this.commentSet = recipe.getCommentSet();
        } else if(recipe.getRecipe() != null){
            this.recipe = recipe.getRecipe();
        }
    }


}
