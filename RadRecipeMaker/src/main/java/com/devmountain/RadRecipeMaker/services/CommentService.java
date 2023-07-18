package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CommentService {
    @Transactional
    List<String> addComment(CommentDto commentDto, Long recipe_id, Long user_id);


    @Transactional
    void deleteComment(long commentId);
}
