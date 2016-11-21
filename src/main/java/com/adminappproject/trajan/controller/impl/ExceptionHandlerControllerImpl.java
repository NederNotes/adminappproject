package com.adminappproject.trajan.controller.impl;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerImpl {

	/*
	 * @ResponseStatus(value = HttpStatus.CONFLICT, reason =
	 * "Data integrity violation") // 409
	 */
	/*
	 * @ExceptionHandler({ SQLException.class, DataAccessException.class })
	 * public ResponseEntity<Exception> databaseError(HttpServletRequest req,
	 * Exception e) throws Exception { return new ResponseEntity<Exception>(e,
	 * HttpStatus.CONFLICT); }
	 */
	
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public void databaseError() throws Exception {

	}
}
