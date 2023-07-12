package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.entities.Comment;
import com.devmountain.RadRecipeMaker.entities.Recipe;
import com.devmountain.RadRecipeMaker.repositories.CommentRepository;
import com.devmountain.RadRecipeMaker.repositories.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public List<String> addComment(CommentDto commentDto, Long recipeId){
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        List<String> response = new ArrayList<>();
        Comment comment = new Comment(commentDto);
        recipeOptional.isPresent();
        commentRepository.saveAndFlush(comment);
        response.add("Successfully added Comment");
        return response;
    }

    @Override
    @Transactional
    public void deleteComment(long commentId){
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        commentOptional.ifPresent(comment -> commentRepository.delete(comment));
    }
}
