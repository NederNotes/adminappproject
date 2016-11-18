package com.adminappproject.trajan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.adminappproject.trajan.dto.ApiErrorDtl;

@Service
public interface ErrorHandlerService {
	public List<ApiErrorDtl> compileErrorMsg(Errors errors);
}
