package com.Exception.exception;

public class BlogNotFoundException extends RuntimeException {
	
	public BlogNotFoundException(String message) {
		super(message);
	}

	public BlogNotFoundException() {
	}

}
