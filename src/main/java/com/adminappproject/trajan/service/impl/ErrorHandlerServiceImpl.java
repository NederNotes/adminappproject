package com.adminappproject.trajan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.adminappproject.trajan.dto.ApiErrorDtl;
import com.adminappproject.trajan.service.ErrorHandlerService;

@Component
public class ErrorHandlerServiceImpl implements ErrorHandlerService {

	@Override
	public List<ApiErrorDtl> compileErrorMsg(Errors errors) {
		List<ApiErrorDtl> apiErrorDtls = new ArrayList<>();
		List<FieldError> errorFields = errors.getFieldErrors();

		for (FieldError fieldError : errorFields) {
			ApiErrorDtl apiErrorDtl = new ApiErrorDtl();
			apiErrorDtl.setMessage(fieldError.getCode());
			apiErrorDtl.setRejectedValue(fieldError.getRejectedValue().toString());
			apiErrorDtl.setErrorsField(fieldError.getField());

			apiErrorDtls.add(apiErrorDtl);
		}

		return apiErrorDtls;
	}

}
