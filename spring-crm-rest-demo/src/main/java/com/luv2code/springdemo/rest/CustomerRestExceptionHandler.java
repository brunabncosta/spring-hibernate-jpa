package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add an exceptio handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e) {
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											e.getMessage(),
											System.currentTimeMillis());
		
		// return Resp0onseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// add another exception handler ... to catch any exception
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e) {
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											e.getMessage(),
											System.currentTimeMillis());
		
		// return Resp0onseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
