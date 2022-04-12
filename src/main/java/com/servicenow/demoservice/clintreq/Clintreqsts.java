package com.servicenow.demoservice.clintreq;

import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.servicenow.demoservice.exception.Attrib;
import com.servicenow.demoservice.exception.Praseexception;
import com.servicenow.demoservice.exception.RecordNotFound;
import com.servicenow.demoservice.exception.Unauthorize;
import com.servicenow.demoservice.exception.Unknown;
import com.servicenow.demoservice.model.Result;


@RestController
@RequestMapping("/table")
public class Clintreqsts  { 
    @Autowired
    Businesslogic bus;
	//GET-D
	@GetMapping("/records")
	public  ResponseEntity<?> getList(){
		//List<Userreq>  out =    Businesslogic.getList();
		Map out = bus.getList();
		return new ResponseEntity<>(out,HttpStatus.OK);
	}
	//GET-D
	@GetMapping("/records/{number}")
	public  ResponseEntity<?> getListById(@PathVariable String number){
		String o=null;
		Map out = null;
		try {
			o = bus.getListById(number);
			return new ResponseEntity<>(o,HttpStatus.OK);
			}catch(HttpClientErrorException e) {
				if(e.getRawStatusCode() == 404) {
					throw new RecordNotFound(HttpStatus.NOT_FOUND,"Record Not Found");
				}
				if(e.getRawStatusCode() == 401) {
					throw new Unauthorize(HttpStatus.UNAUTHORIZED, "Check creentials");
				}
			}
		catch(HttpServerErrorException s) {
				throw new RecordNotFound(HttpStatus.BAD_GATEWAY,"Record Not Found");
			}
		
			return new ResponseEntity<>(out,HttpStatus.BAD_REQUEST);
		
	}		
	//POST -D
	@PostMapping("/record")
	public ResponseEntity<?> res(@RequestBody Result s){
		//java.net.UnknownHostException
		//String result = Businesslogic.createDetatils(s);
		System.out.println(s.getCaller_id()+"---"+s.getShort_description());
		if(s.getCaller_id()==null || s.getShort_description() == null) {
			//throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "check Attributes", null);
			throw new Attrib("attributes");
		}
		else {
			try {
		String result1 = bus.createDetatils(s);
		return new ResponseEntity<>(result1,HttpStatus.CREATED);
			}
		catch(HttpClientErrorException e) {
			if(e.getRawStatusCode() == 400) {
				//bad request
				e.getStackTrace();
			}
		}
			return null;
		}
	}
	
	//PUT-D
	@PutMapping("/records/{id}")
	public ResponseEntity<?> uodate(@RequestBody Result re ,@PathVariable String id){
		String out = "Not Updated";
		try {
			out = bus.updateDetatils(re,id);
			return new ResponseEntity<>(out,HttpStatus.OK);
			}catch(HttpClientErrorException e) {
				if(e.getRawStatusCode() == 404) {
					throw new RecordNotFound(HttpStatus.NOT_FOUND,"Record Not Found");
				}
			}catch(HttpServerErrorException s) {
				throw new RecordNotFound(HttpStatus.BAD_GATEWAY,"Record Not Found");
			}catch (HttpMessageNotReadableException e) {
				throw new Praseexception("Check the JSON Syntax");
				// TODO: handle exception
			}
		
			return new ResponseEntity<>(out,HttpStatus.BAD_GATEWAY);
		
	
	}
	
	//working
	@DeleteMapping("/{id}")
	public  ResponseEntity<?> removeById(@PathVariable String id){
		String out ="Empty";
		try {
		out = bus.removeById(id);
		return new ResponseEntity<>(out,HttpStatus.OK);
		}catch(HttpClientErrorException e) {
			if(e.getRawStatusCode() == 404) {
				throw new RecordNotFound(HttpStatus.NOT_FOUND,"Record Not Found");
			}
		}catch(HttpServerErrorException s) {
			throw new RecordNotFound(HttpStatus.BAD_GATEWAY,"Record Not Found");
		}
		return new ResponseEntity<>(out,HttpStatus.BAD_GATEWAY);
		//System.out.println(Businesslogic.getList());
		
		
	}
	
	
	

    }
	
	
	

	
/*
 * @GetMapping("/list1/{number}")
	public  ResponseEntity<?> getListById1(@PathVariable String number){
		//List<Userreq>  out =    Businesslogic.getList();
		String out = null;
		try {
		 out = bus.getListById1(number);
		}catch(Exception e) {
			e.getLocalizedMessage();
		}
		
		return new ResponseEntity<>(out,HttpStatus.OK);
	}*/	
	
	
	



