package com.servicenow.demoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;


@RestControllerAdvice
public class Exce  extends RuntimeException{
	
	
	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<?> notFound(RecordNotFound e,WebRequest rq){
		String code = ""+e.getRawStatusCode();
		Errorinfo ob = new Errorinfo("Record not Found",code , rq.getDescription(false));
		return new ResponseEntity<>(ob, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Attrib.class)
	public ResponseEntity<?> reqAtt(Attrib a, WebRequest re){
		Errorinfo o = new Errorinfo("Check Attributes",HttpStatus.BAD_REQUEST.toString(),re.getDescription(false));
		return new ResponseEntity<>(o,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Unknown.class)
	public ResponseEntity<?> unknown(Unknown a,WebRequest wr){
		Errorinfo o = new Errorinfo("unknowHost  Exception",HttpStatus.BAD_REQUEST.toString(),wr.getDescription(false));
		return new ResponseEntity<>(o, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Unauthorize.class)
	public ResponseEntity<?> unAuth(Unauthorize a,WebRequest wr){
		Errorinfo o = new Errorinfo(" Check Credentials",HttpStatus.UNAUTHORIZED.toString(),wr.getDescription(false));
		return new ResponseEntity<>(o, HttpStatus.UNAUTHORIZED);
		
	}
	@ExceptionHandler(Praseexception.class)
	public ResponseEntity<?> prase(Praseexception p,WebRequest r){
		Errorinfo o = new Errorinfo("Check with JSON body",HttpStatus.BAD_REQUEST.toString(),r.getDescription(false));
		return new ResponseEntity<>(o, HttpStatus.BAD_REQUEST);
	}
	

}
