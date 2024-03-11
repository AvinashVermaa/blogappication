package com.myblogapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myblogapi.payload.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandlerForBlogApp extends ResponseEntityExceptionHandler{

	//this method is used to handle the specific exception for resource not found exception in the application:
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest){
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
	
	//this method is used to handle the specific exception for blogapi exception occurs in the application:
	@ExceptionHandler(value = BlogApiException.class)
	public ResponseEntity<ErrorDetails> handleBlogApiException(BlogApiException exception,WebRequest webRequest){
		ErrorDetails details = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
	
	//this method is used to handle the global exception occurs in the application:
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalExceptionForBlogApp(Exception exception,WebRequest webRequest){
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
