package com.cts.key.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.key.model.AppErrorResponse;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(KeyException.class)
	protected ResponseEntity<AppErrorResponse> ErrorResponsehandleExceptionKeyNotFound(Exception ex,WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
					new AppErrorResponse(LocalDateTime.now(),
							HttpStatus.NOT_FOUND.value(),
							ex.getMessage(),
							request.getDescription(false)
							)
				);		
	}

}
