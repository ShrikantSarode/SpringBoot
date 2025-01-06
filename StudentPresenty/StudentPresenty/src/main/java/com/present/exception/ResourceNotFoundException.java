package com.present.exception;

public class ResourceNotFoundException extends RuntimeException {

	// Default constructor
	public ResourceNotFoundException(String message) {
		super(message);
	}
}