package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.grievance.dto.ChangePasswordDto;

public class ChangePasswordTest {

  @Test
  public void hashCodeTest() {
	  ChangePasswordDto change = new ChangePasswordDto();
	  change.setConfirmPassword("ksdbvs");
	  change.setNewPassword("adadada");
	  change.setConfirmPassword("adadada");
	  
	  ChangePasswordDto change1 = new ChangePasswordDto();
	  change1.setConfirmPassword("ksdbvs");
	  change1.setNewPassword("adadada");
	  change1.setConfirmPassword("adadada");
	  
	  ChangePasswordDto change2 = new ChangePasswordDto();
	  change2.setConfirmPassword("adfa");
	  change2.setNewPassword("ada");
	  change2.setConfirmPassword("adadada");
	  
	  assertEquals(change.hashCode(), change1.hashCode());
	  assertNotEquals(change.hashCode(), change2.hashCode());
  }
  
  @Test
  void equalsTest() {
	  ChangePasswordDto change = new ChangePasswordDto();
	  change.setConfirmPassword("ksdbvs");
	  change.setNewPassword("adadada");
	  change.setConfirmPassword("adadada");
	  
	  ChangePasswordDto change1 = new ChangePasswordDto();
	  change1.setConfirmPassword("ksdbvs");
	  change1.setNewPassword("adadada");
	  change1.setConfirmPassword("adadada");
	  
	  ChangePasswordDto change2 = new ChangePasswordDto();
	  change2.setConfirmPassword("adfa");
	  change2.setNewPassword("adadada");
	  change2.setConfirmPassword("adadada");
	  
	  assertThat(change.equals(change1));
	  assertThat(!change.equals(change2));
	  assertThat(change.equals(change));
	  assertThat(!change.equals(null));
	  assertThat(!change.equals(new Department()));
  }
}

