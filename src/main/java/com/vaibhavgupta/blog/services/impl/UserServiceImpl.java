package com.vaibhavgupta.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavgupta.blog.entites.User;
import com.vaibhavgupta.blog.exceptions.ResourceNotFoundException;
import com.vaibhavgupta.blog.payload.UserDto;
import com.vaibhavgupta.blog.repositories.UserRepo;
import com.vaibhavgupta.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo; 
	
	@Autowired
	private ModelMapper mapper;
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
		User user1 = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id" ,userId));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setAbout(user.getAbout());
		
		User updatedUser = this.userRepo.save(user1);
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id" ,userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getUserList() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		List<UserDto> usersDto = users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
		return usersDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId) );
		this.userRepo.delete(user);
	}
	
	private User dtoToUser(UserDto userDto) {
		
		User user = this.mapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
		
	}
	
	public UserDto userToDto(User user) {
		UserDto userdto =this.mapper.map(user, UserDto.class);
//		userdto.setId(user.getId());
//		userdto.setName(user.getName());
//		userdto.setPassword(user.getPassword());
//		userdto.setEmail(user.getEmail());
//		userdto.setAbout(user.getAbout());
		
		return userdto;
	}

}
