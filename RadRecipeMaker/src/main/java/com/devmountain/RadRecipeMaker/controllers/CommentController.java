package com.devmountain.RadRecipeMaker.controllers;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import com.devmountain.RadRecipeMaker.entities.User;
import com.devmountain.RadRecipeMaker.services.CommentService;
import com.devmountain.RadRecipeMaker.services.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;




    @PostMapping("/{recipe_id}/comments")
    public List<String> addComment(@RequestBody CommentDto commentDto, @PathVariable Long recipe_id){
        Optional<User> userOptional = userService.
        return commentService.addComment(commentDto,  recipe_id, );
    }

    @DeleteMapping("/{recipe_id}/{comment_id}")
    public void deleteComment(@PathVariable Long recipe_id, @PathVariable Long comment_id){
        System.out.println("Successfully Deleted");
        commentService.deleteComment(comment_id);
    }



}
