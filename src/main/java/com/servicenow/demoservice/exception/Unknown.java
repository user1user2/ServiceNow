package com.servicenow.demoservice.exception;

import java.net.UnknownHostException;

public class Unknown extends RuntimeException {
	public String message;
	public Unknown(String message) {
		this.message=message;
	}
  
}
