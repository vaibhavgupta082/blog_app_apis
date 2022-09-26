package com.vaibhavgupta.blog.services;

import java.util.List;

import com.vaibhavgupta.blog.payload.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user); 
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getUserList();
	
	void deleteUser(Integer userId);
	
}
