package com.example.demo.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.entity.Comment;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;

public class CommentTest {
	
	Comment comment;
	
	@BeforeEach
	public void setup() {
		comment = new Comment();
		
		comment.setCommentId(1);
		comment.setContent("hello Testers");
		comment.setCreationTime(null);
		comment.setEmpName("Testers");
		comment.setTicket(null);
		
		
	}
	
	@Test
	public void getters_testing_ticket() {
		
		assertEquals(comment.getCommentId(), (Integer)1);
		assertEquals(comment.getContent(), "hello Testers");
		assertEquals(comment.getCreationTime(), null);
		assertEquals(comment.getEmpName(), "Testers");
		assertEquals(comment.getTicket(), null);
	}
	
	@Test
	public void allArgsConstructor_testing() {
		Comment comment1 = new Comment(1 , "testing" , null , "Tester1" , null);
	}
}

