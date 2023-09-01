package com.grievance.service;

import com.grievance.dto.CommentsDto;
import com.grievance.entity.Comment;
import com.grievance.repo.CommentsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Comment service.
 */
public class CommentService {
  @Autowired
  private CommentsRepo commentsRepo;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * Save comment.
   */
  public CommentsDto saveComment(CommentsDto commentsDto) {
    Comment comment = this.modelMapper.map(commentsDto, Comment.class);

    Comment savedComment = this.commentsRepo.save(comment);

    return this.modelMapper.map(savedComment, CommentsDto.class);
  }
  
}
