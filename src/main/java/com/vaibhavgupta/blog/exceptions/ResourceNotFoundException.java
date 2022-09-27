package com.vaibhavgupta.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	String resourcename;
	String fieldname;
	long fieldValue;
	public ResourceNotFoundException(String resourcename, String fieldname, long fieldValue) {
		super(String.format("%s not found with %s : %s ",resourcename,fieldname,fieldValue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldValue = fieldValue;
	}
	
	


}
