package com.devmountain.RadRecipeMaker.controllers;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.services.CommentService;
import com.devmountain.RadRecipeMaker.services.RecipeService;
import com.devmountain.RadRecipeMaker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipes")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    

    @PostMapping("/{recipe_id}/addcomment")
    public List<String> addComment(@RequestBody CommentDto commentDto, @PathVariable Long recipe_id){
            return commentService.addComment(commentDto, commentDto.getRecipe(), commentDto.getUser());
    }

    @DeleteMapping("/{recipe_id}/{comment_id}")
    public void deleteComment(@RequestBody CommentDto commentDto){
        commentService.deleteComment(commentDto.getId());
    }

}
