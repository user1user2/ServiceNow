package com.servicenow.demoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class Unauthorize extends HttpClientErrorException{

	public Unauthorize(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
		// TODO Auto-generated constructor stub
	}
	

}
