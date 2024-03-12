package com.example.JOBSHOP.JOBSHOP.errors;

import java.time.LocalDateTime;
import java.util.List;

public class errorResponse {
	
	private Boolean success;
	private String message;
	private LocalDateTime time;
	private	List<String> details;
	
	
	public errorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public errorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.success = Boolean.FALSE;
		this.time = LocalDateTime.now();
		
	}


	public Boolean getSuccess() {
		return success;
	}


	public void setSuccess(Boolean success) {
		this.success = success;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
		this.time = time;
	}


	public List<String> getDetails() {
		return details;
	}


	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
	
	

}
