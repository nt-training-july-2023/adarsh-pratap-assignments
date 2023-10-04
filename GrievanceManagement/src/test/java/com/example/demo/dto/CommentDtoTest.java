package com.example.demo.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.CommentsDto;

public class CommentDtoTest {
	
	private CommentsDto comment;
	
	@BeforeEach
	void setup() {
		comment = new CommentsDto();
		comment.setCommentId(1);
		comment.setContent("fgfgdfdgd");
		comment.setCreationTime(null);
		comment.setEmpName("Adarsh");
		comment.setTicket(null);
	}
	
	@Test
	void setter() {
		Assertions.assertEquals(1, comment.getCommentId());
		Assertions.assertEquals("fgfgdfdgd", comment.getContent());
		Assertions.assertEquals(comment.getEmpName(), "Adarsh");
		Assertions.assertEquals(null, comment.getCreationTime());
		Assertions.assertEquals(null, comment.getTicket());
	}
}

