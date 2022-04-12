package com.servicenow.demoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class RecordNotFound extends HttpClientErrorException {

	public RecordNotFound(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
		// TODO Auto-generated constructor stub
	}

	

}
