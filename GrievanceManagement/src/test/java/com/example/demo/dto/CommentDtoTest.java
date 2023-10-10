package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	
	@Test
	void hashCodeTest() {
		CommentsDto comm = new CommentsDto();
		comm.setCommentId(1);
		comm.setContent("djfhbsfj");
		comm.setCreationTime(null);
		comm.setEmpName("Adarsh");
		comm.setTicket(null);
		
		CommentsDto comm1 = new CommentsDto();
		comm1.setCommentId(1);
		comm1.setContent("djfhbsfj");
		comm1.setCreationTime(null);
		comm1.setEmpName("Adarsh");
		comm1.setTicket(null);
		
		CommentsDto comm2 = new CommentsDto();
		comm2.setCommentId(1);
		comm2.setContent("djfh");
		comm2.setCreationTime(null);
		comm2.setEmpName("Adarsh");
		comm2.setTicket(null);
		
		assertEquals(comm.hashCode(), comm1.hashCode());
		assertNotEquals(comm1.hashCode(), comm2.hashCode());
	}
	
	@Test
	public void equalsMethod() {
		CommentsDto comm = new CommentsDto();
		comm.setCommentId(1);
		comm.setContent("djfhbsfj");
		comm.setCreationTime(null);
		comm.setEmpName("Adarsh");
		comm.setTicket(null);
		
		CommentsDto comm1 = new CommentsDto();
		comm1.setCommentId(1);
		comm1.setContent("djfhbsfj");
		comm1.setCreationTime(null);
		comm1.setEmpName("Adarsh");
		comm1.setTicket(null);
		
		CommentsDto comm2 = new CommentsDto();
		comm2.setCommentId(1);
		comm2.setContent("djfh");
		comm2.setCreationTime(null);
		comm2.setEmpName("Adarsh");
		comm2.setTicket(null);
		
		assertThat(comm.equals(comm1));
		assertThat(!comm.equals(comm2));
		assertThat(!comm.equals(null));
		assertThat(!comm.equals(new Department()));
		assertThat(comm.equals(comm));
	}

}

