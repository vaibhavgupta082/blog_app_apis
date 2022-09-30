package com.vaibhavgupta.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.utility.nullability.NeverNull;

@NoArgsConstructor
@Getter
@Setter
 
public class UserDto {

	private int id;
	
	@NotNull
	private String name;
	
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String about;
	

}
