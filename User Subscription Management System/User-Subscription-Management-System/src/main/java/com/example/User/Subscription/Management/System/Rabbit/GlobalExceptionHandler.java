package com.example.User.Subscription.Management.System.Rabbit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.User.Subscription.Management.System.Exception.SubscriptionNotFoundException;
import com.example.User.Subscription.Management.System.Exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	/*
	 * @ExceptionHandler({UserNotFoundException.class,
	 * SubscriptionNotFoundException.class}) public ResponseEntity<ErrorResponse>
	 * handleNotFoundException(RuntimeException ex) { return new
	 * ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
	 * ex.getMessage()), HttpStatus.NOT_FOUND); }
	 * 
	 * @ExceptionHandler(DuplicateEmailException.class) public
	 * ResponseEntity<ErrorResponse>
	 * handleDuplicateEmailException(DuplicateEmailException ex) { return new
	 * ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.value(),
	 * ex.getMessage()), HttpStatus.CONFLICT); }
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<ErrorResponse>
	 * handleValidationException(MethodArgumentNotValidException ex) { String
	 * message = ex.getBindingResult().getFieldErrors().stream()
	 * .map(FieldError::getDefaultMessage) .collect(Collectors.joining(", "));
	 * return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
	 * message), HttpStatus.BAD_REQUEST); }
	 */}