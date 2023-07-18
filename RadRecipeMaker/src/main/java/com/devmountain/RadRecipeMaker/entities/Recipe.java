package com.devmountain.RadRecipeMaker.entities;

import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
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
    private String recipeName;

    @Column
    private String recipeIngredients;

    @Column
    private String recipe;

    @OneToMany(mappedBy = "recipe", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference(value="recipe")
    private Set<Long> commentSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Recipe(RecipeDto recipeDto) {
        this.id = recipeDto.getId();
        this.recipeName = recipeDto.getRecipe_name();
        this.recipeIngredients = recipeDto.getRecipe_ingredients();
        this.recipe = recipeDto.getRecipe();
        this.commentSet = recipeDto.getCommentSet();
    }



    public Set<Long> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Long> commentSet) {
        this.commentSet = commentSet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeIngredients() {
        return this.recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipe() {
        return this.recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
