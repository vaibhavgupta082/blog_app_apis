package com.vaibhavgupta.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vaibhavgupta.blog.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resoureNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apires = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apires,HttpStatus.NOT_FOUND);
	}
}
