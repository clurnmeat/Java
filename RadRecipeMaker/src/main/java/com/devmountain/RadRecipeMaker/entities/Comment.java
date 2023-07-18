package com.devmountain.RadRecipeMaker.entities;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    @ManyToOne
    @JsonBackReference(value = "user")
    private User user;


    @ManyToOne
    @JsonBackReference(value = "recipe")
    private Recipe recipe;

    public Comment(CommentDto commentDto, User user, Recipe recipe) {
        this.id = commentDto.getId();
        this.comment = commentDto.getComment();
        this.user = user;
        this.recipe = recipe;
    }


    public void setUser(CommentDto commentDto) {
        this.user = commentDto.getUser();
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return this.user;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
