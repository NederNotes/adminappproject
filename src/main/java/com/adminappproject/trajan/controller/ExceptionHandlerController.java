package com.adminappproject.trajan.controller;

import org.springframework.http.ResponseEntity;

import com.adminappproject.trajan.dto.ApiErrorExceptionDTO;

import javax.servlet.http.HttpServletRequest;

public interface ExceptionHandlerController {
   public ResponseEntity<ApiErrorExceptionDTO> databaseError(HttpServletRequest req, Exception exception);
}
