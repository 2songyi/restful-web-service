package com.xyz.restfulwerbservice.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.xyz.restfulwerbservice.user.UserNotFoundException;

@RestController
@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	// 어떠한 컨트롤러가 실행된다 하더라도 advice핸들러가 실행될것이다.
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
		// Status: 500 Internal Server Error
	}
	
	//UserNotFountExcption이 발생되면 실행시킬 예외
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
		
		// Status: 404 Not Found
	}
}
