package com.vaibhavgupta.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhavgupta.blog.entites.User;
import com.vaibhavgupta.blog.payload.UserDto;
import com.vaibhavgupta.blog.repositories.UserRepo;
import com.vaibhavgupta.blog.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo; 
	@Override
	public UserDto createUser(UserDto userdto) {
		// TODO Auto-generated method stub
		User user =  this.dtoToUser(userdto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	
	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
		
	}
	
	public UserDto userToDto(User user) {
		UserDto userdto = new UserDto();
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setPassword(user.getPassword());
		userdto.setEmail(user.getEmail());
		userdto.setAbout(user.getAbout());
		
		return userdto;
	}

}
