package fr.eni.cavevin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	String notFoundHandler(RuntimeException ex) {
		return "notFoundHandler - " + ex.getMessage();
	}
}
