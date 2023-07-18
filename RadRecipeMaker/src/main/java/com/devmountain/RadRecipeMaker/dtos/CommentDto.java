package com.devmountain.RadRecipeMaker.dtos;

import com.devmountain.RadRecipeMaker.entities.Comment;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import com.devmountain.RadRecipeMaker.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {
    private Long id;

    private String comment;

    private User user;

    private Recipe recipe;

    public CommentDto(CommentDto comment, User user, Recipe recipe){
        if(comment.getId() != null){
            this.id = comment.getId();
        }
        if(comment.getComment() != null){
            this.comment = comment.getComment();
        }
        if(user.getId() != null){
            this.user = user;
        }
        if(recipe.getId() != null){
            this.recipe = recipe;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }



}
