package com.adminappproject.trajan.controller.impl;

import com.adminappproject.trajan.controller.ExceptionHandlerController;
import com.adminappproject.trajan.dto.ApiError;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlerControllerImpl implements ExceptionHandlerController {

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

    @Override
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ResponseEntity<ApiError> databaseError(HttpServletRequest req, Exception exception) {
        return null;
    }
}
