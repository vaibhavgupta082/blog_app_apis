package com.vaibhavgupta.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min = 4,message = "Username must be min of 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid!!!")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max =10,message = "password must be min 3 chars and maximum 10 chars")
	private String password;
	
	@NotEmpty
	private String about;
	

}
