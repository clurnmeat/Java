package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.CommentDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CommentService {


    @Transactional
    List<String> addComment(CommentDto commentDto);

    void deleteComment(long commentId);
}
