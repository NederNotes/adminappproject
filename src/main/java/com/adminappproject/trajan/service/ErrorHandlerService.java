package com.adminappproject.trajan.service;

import com.adminappproject.trajan.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public interface ErrorHandlerService {
    public ApiError compileApiErrorMsg(Errors errors, HttpStatus httpStatus, String generalMsg);
}
