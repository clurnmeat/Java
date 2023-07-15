package com.devmountain.RadRecipeMaker.controllers;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.entities.Comment;
import com.devmountain.RadRecipeMaker.repositories.CommentRepository;
import com.devmountain.RadRecipeMaker.repositories.RecipeRepository;
import com.devmountain.RadRecipeMaker.services.CommentService;
import com.devmountain.RadRecipeMaker.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class CommentController {
    @Autowired
    private CommentService commentService;





    @PostMapping("/{recipe_id}/comments")
    public List<String> addComment(@RequestBody CommentDto commentDto, @PathVariable Long recipe_id){
        return commentService.addComment(commentDto);
    }

    @DeleteMapping("/{recipe_id}/{comment_id}")
    public void deleteComment(@PathVariable Long recipe_id, @PathVariable Long comment_id){
        commentService.deleteComment(comment_id);
    }



}
