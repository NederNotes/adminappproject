package com.adminappproject.trajan.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface ApiErrorService<E, T> {
	public E compileApiErrorMsg(T errors, HttpStatus httpStatus);
}
