package com.example.demo;

import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException  {


	
	public UserNotFoundException(String string, String string2, Throwable cause) {
		super(cause);
		errorCode =string;
		errorMessage = string2;
	}
	String errorCode;
	String errorMessage;

}
