package com.vaibhavgupta.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhavgupta.blog.payload.UserDto;
import com.vaibhavgupta.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//POST-Create
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
		UserDto createdUser = this.userService.createUser(userdto);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}

}
