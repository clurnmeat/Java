package com.devmountain.RadRecipeMaker.entities;

import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String recipe_name;

    @Column
    private String recipe_ingredients;

    @Column
    private String recipe;

    @OneToMany(mappedBy = "recipe", cascade = {CascadeType.MERGE, CascadeType.ALL})
    @JsonManagedReference(value="recipe-comment")
    private Set<Comment> commentSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Recipe(RecipeDto recipeDto) {
        this.id = recipeDto.getId();
        this.recipe_name = recipeDto.getRecipe_name();
        this.recipe_ingredients = recipeDto.getRecipe_ingredients();
        this.recipe = recipeDto.getRecipe();
        this.commentSet = recipeDto.getCommentDtoSet();
    }



    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipe_name;
    }

    public void setRecipeName(String recipeName) {
        this.recipe_name = recipeName;
    }

    public String getRecipeIngredients() {
        return recipe_ingredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipe_ingredients = recipeIngredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
