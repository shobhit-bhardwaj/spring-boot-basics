package com.shobhit.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler (RuntimeException.class)
	public ProblemDetail handleRuntimeException(RuntimeException ex) {
		log.info("handleRuntimeException - " + ex);

		return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), "RuntimeException, " + ex.getMessage());
	}

	@ExceptionHandler (InvalidDataException.class)
	public ProblemDetail handleInvalidDataException(InvalidDataException ex) {
		log.info("handleInvalidDataException - " + ex);

		return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), "InvalidDataException, " + ex.getMessage());
	}
}
