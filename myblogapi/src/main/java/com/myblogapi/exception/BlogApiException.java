package com.myblogapi.exception;

public class BlogApiException extends Exception{

	private String status;
	private String message;
	
	
	public BlogApiException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlogApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public BlogApiException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public BlogApiException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public BlogApiException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public BlogApiException(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
