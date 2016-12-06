package com.axa.sesummit.codinggame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

	public static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Request not allowed / misformed")
	public void onError(Throwable t) {
		LOG.info("Found error: " + t.getMessage(), t);
	}

}
