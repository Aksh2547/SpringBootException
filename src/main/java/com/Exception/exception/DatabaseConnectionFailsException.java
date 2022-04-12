package com.Exception.exception;

public class DatabaseConnectionFailsException extends RuntimeException{
	
	public DatabaseConnectionFailsException(String messege) {
		super(messege);
	}
	
	public DatabaseConnectionFailsException() {
		
	}

}
