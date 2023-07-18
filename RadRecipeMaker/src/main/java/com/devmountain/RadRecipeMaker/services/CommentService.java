package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.dtos.RecipeDto;
import com.devmountain.RadRecipeMaker.dtos.UserDto;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import com.devmountain.RadRecipeMaker.entities.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CommentService {
    @Transactional
    List<String> addComment(CommentDto commentDto, Recipe recipeDto, User userDto);


    @Transactional
    void deleteComment(long commentId);
}
