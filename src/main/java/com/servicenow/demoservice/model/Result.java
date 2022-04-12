package com.servicenow.demoservice.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName(value = "my_pojo")
public class Result implements Serializable {

	
	
	@JsonProperty("number")
	private Object number;
	
	private Object category;
	private String upon_approval;
	
	private Object caller_id;
	@JsonProperty("short_description")
	private Object short_description;
	
	
	
	public Object getNumber() {
		return number;
	}



	public void setNumber(Object number) {
		this.number = number;
	}



	public Object getCategory() {
		return category;
	}



	public void setCategory(Object category) {
		this.category = category;
	}



	public String getUpon_approval() {
		return upon_approval;
	}



	public void setUpon_approval(String upon_approval) {
		this.upon_approval = upon_approval;
	}



	public Object getCaller_id() {
		return caller_id;
	}



	public void setCaller_id(Object caller_id) {
		this.caller_id = caller_id;
	}



	public Object getShort_description() {
		return short_description;
	}



	public void setShort_description(Object short_description) {
		this.short_description = short_description;
	}



	public Result() {};
	
	
	
	
}
