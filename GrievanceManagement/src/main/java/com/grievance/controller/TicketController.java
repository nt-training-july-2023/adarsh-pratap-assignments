package com.grievance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grievance.dto.TicketDto;
import com.grievance.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/add")
	public ResponseEntity<?> createTicket(@Valid @RequestBody TicketDto ticketDto){
		return new ResponseEntity<>(this.ticketService.addTicket(ticketDto) , HttpStatus.CREATED);
	}
}

