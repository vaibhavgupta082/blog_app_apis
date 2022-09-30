package com.vaibhavgupta.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName,message);
		} );
		
		return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
	}
}
