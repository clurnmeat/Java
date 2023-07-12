package com.devmountain.RadRecipeMaker.entities;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonBackReference(value = "user-comment")
    private User user;


    @ManyToOne
    @JsonBackReference(value = "recipe-comment")
    private Recipe recipe;

    public Comment(CommentDto commentDto) {
    }


    public User getUser() {
        return user;
    }

    public Recipe getRecipe() {
        return recipe;
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
}
