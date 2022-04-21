package com.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {

	@ExceptionHandler(value = ResourceNotFound.class)
	public ResponseEntity<Object> getException(ResourceNotFound resourceNotFound) {
		return new ResponseEntity<>("Id not found: ", HttpStatus.NOT_FOUND);
	}

}
