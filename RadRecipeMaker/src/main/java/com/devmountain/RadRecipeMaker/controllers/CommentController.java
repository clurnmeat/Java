package com.devmountain.RadRecipeMaker.controllers;

import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.entities.Comment;
import com.devmountain.RadRecipeMaker.repositories.CommentRepository;
import com.devmountain.RadRecipeMaker.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping("/{recipe_name}")
    public Optional<Comment>  addComment(@RequestBody RecipeDto recipeDto){
        recipeDto.getCommentDtoSet().add()
    }

}
