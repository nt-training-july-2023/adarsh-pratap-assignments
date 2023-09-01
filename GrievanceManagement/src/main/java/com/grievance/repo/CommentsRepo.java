package com.grievance.repo;

import com.grievance.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Comments Repository.
 */
public interface CommentsRepo extends JpaRepository<Comment, Integer> {}
