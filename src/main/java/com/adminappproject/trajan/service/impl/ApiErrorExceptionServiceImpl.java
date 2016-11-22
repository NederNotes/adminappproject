package com.adminappproject.trajan.service.impl;

import org.springframework.http.HttpStatus;

import com.adminappproject.trajan.dto.ApiErrorExceptionDTO;
import com.adminappproject.trajan.service.ApiErrorService;

public class ApiErrorExceptionServiceImpl implements ApiErrorService<ApiErrorExceptionDTO, Exception>{

	@Override
	public ApiErrorExceptionDTO compileApiErrorMsg(Exception errors, HttpStatus httpStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
