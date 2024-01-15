package com.natixis.exercice.cart.exception;


//Custom exception for handling issues related to JSON file generation

public class JsonGenerationException extends RuntimeException {
 
	private static final long serialVersionUID = -839464084767369081L;

	public JsonGenerationException(String message, Throwable cause) {
		super(message, cause);
	}
}
