package com.adminappproject.trajan.controller.impl;

import com.adminappproject.trajan.controller.ExceptionHandlerController;
import com.adminappproject.trajan.dto.ApiErrorExceptionDTO;
import com.adminappproject.trajan.service.ApiErrorService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlerControllerImpl implements ExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerImpl.class);

    @Resource(name="apiErrorExceptionServiceImpl")
    private ApiErrorService<ApiErrorExceptionDTO, Exception, HttpStatus> apiErrorService;
    
    @Override
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ResponseEntity<ApiErrorExceptionDTO> databaseError(HttpServletRequest req, Exception exception) {
    	logger.error("On databaseError: {}", ExceptionUtils.getRootCauseMessage(exception));
        ApiErrorExceptionDTO apiErrorExceptionDTO = apiErrorService.compileApiErrorMsg(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ApiErrorExceptionDTO>(apiErrorExceptionDTO , apiErrorExceptionDTO.getHttpStatus());
    }

    @Override
    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ApiErrorExceptionDTO> databaseIntegrityError(HttpServletRequest req, Exception exception) {
    	logger.error("On databaseIntegrityError: {}", ExceptionUtils.getRootCauseMessage(exception));
        ApiErrorExceptionDTO apiErrorExceptionDTO = apiErrorService.compileApiErrorMsg(exception, HttpStatus.CONFLICT);
        return new ResponseEntity<ApiErrorExceptionDTO>(apiErrorExceptionDTO , apiErrorExceptionDTO.getHttpStatus());
    }
}
