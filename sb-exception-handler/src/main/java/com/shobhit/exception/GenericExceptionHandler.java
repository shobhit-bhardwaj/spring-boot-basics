package com.shobhit.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler (InvalidIdException.class)
	public ResponseEntity<String> handleInvalidIdException() {
		return new ResponseEntity<String>("Invalid Id, Please Enter Valid Id", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler (InvalidNameException.class)
	public ResponseEntity<String> handleInvalidNameException() {
		return new ResponseEntity<String>("Invalid Name, Please Enter Valid Name", HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("Http Method Not Supported", HttpStatus.METHOD_NOT_ALLOWED);
	}
}