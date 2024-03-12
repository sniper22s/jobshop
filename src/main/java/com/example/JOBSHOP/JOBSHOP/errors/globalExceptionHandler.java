 package com.example.JOBSHOP.JOBSHOP.errors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class globalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handleRecordNotFound(RecordNotFoundException ex){
		
		errorResponse er = new errorResponse(ex.getLocalizedMessage(),
				Arrays.asList(ex.getMessage()));	
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(er);
		
	}
	
	
	@ExceptionHandler(duplicatedRecordException.class)
	public ResponseEntity<?> handleDuplicateRecord(duplicatedRecordException ex){
		
		errorResponse er = new errorResponse(ex.getLocalizedMessage(),
				Arrays.asList(ex.getMessage()));	
		
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(er);
		
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> errors = new ArrayList<String>();
		
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getDefaultMessage());
		}
		errorResponse error = new errorResponse(ex.toString(),errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(businessException.class)
	public final ResponseEntity<?> handleBusinessException(businessException ex){
		List<String> details = new ArrayList<String>();
		details.add("");
		errorResponse error = new errorResponse(ex.getLocalizedMessage(),details);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);
	}
	
	@ExceptionHandler(RuntimeException.class)
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  public ResponseEntity<Object> handleAllUncaughtException(
	      RuntimeException exception, 
	      WebRequest request
	  )
	
	{
		logger.error("Unknown error occurred", exception);
		errorResponse er = new errorResponse(exception.getLocalizedMessage(),
				Arrays.asList(exception.getMessage()));	
		
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(er);
	  }
}
