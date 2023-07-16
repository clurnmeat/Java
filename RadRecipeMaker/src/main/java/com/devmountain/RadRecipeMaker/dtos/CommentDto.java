package com.devmountain.RadRecipeMaker.dtos;

import com.devmountain.RadRecipeMaker.entities.Comment;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import com.devmountain.RadRecipeMaker.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {
    private Long id;

    private String comment;

    private User user;

    private Recipe recipe;

    public CommentDto(Comment comment){
        if(comment.getId() != null){
            this.id = comment.getId();
        }
        if(comment.getComment() != null){
            this.comment = comment.getComment();
        }
        if(comment.getUser() != null){
            this.user = comment.getUser();
        }
        if(comment.getRecipe() != null){
            this.recipe = comment.getRecipe();
        }
    }

}
