package com.vaibhavgupta.blog.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	//put method
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity(Map.of("message","user deleted successfully"),HttpStatus.OK);
	}
	

}
