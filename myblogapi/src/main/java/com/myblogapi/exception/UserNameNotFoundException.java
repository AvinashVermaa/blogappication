package com.myblogapi.exception;

public class UserNameNotFoundException extends RuntimeException{

	private String message;
	private String description;
	public UserNameNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserNameNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public UserNameNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public UserNameNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public UserNameNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public UserNameNotFoundException(String message, String description) {
		super();
		this.message = message;
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserNameNotFoundException [message=" + message + ", description=" + description + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
