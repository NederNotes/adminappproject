package com.adminappproject.trajan.controller;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface ExceptionHandlerController <T> {
   public ResponseEntity<T> databaseError(HttpServletRequest req, Exception exception);
}
