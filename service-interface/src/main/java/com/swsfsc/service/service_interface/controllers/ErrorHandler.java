package com.swsfsc.service.service_interface.controllers;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(value =
	{
			IllegalArgumentException.class, IllegalStateException.class, SQLException.class
	})
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request)
	{
		String bodyOfResponse = "Access Denied";
		HttpStatus status = HttpStatus.FORBIDDEN;
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), status, request);
	}
}