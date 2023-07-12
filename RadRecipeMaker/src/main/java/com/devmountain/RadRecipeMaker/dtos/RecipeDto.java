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
    private String recipe;
    private String recipe_ingredients;
    private String recipe_name;


    private Set<Comment> commentDtoSet = new HashSet<>();



    public RecipeDto(Recipe recipe){

        if(recipe.getId() != null){
            this.id = recipe.getId();
        }
        if(recipe.getRecipeName() != null){
            this.recipe_name = recipe.getRecipeName();
        }

        if(recipe.getRecipeIngredients() != null){
            this.recipe_ingredients = recipe.getRecipeIngredients();
        }

        if(recipe.getRecipe() != null){
            this.recipe = recipe.getRecipe();
        }



    }


}
