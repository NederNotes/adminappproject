package com.adminappproject.trajan.service.impl;

import com.adminappproject.trajan.dto.ApiError;
import com.adminappproject.trajan.dto.ApiErrorDtl;
import com.adminappproject.trajan.service.ErrorHandlerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorHandlerServiceImpl implements ErrorHandlerService {

	@Override
	public ApiError compileApiErrorMsg(Errors errors, HttpStatus httpStatus, String generalMsg) {
		ApiError apiError = new ApiError();
		apiError.setStatus(httpStatus);
		apiError.setErrorFlag(Boolean.TRUE);
		apiError.setGeneralMsg(generalMsg);
		apiError.setApiErrorDtls(compileApiErrorMsgDtl(errors));
		return apiError;
	}

	private List<ApiErrorDtl> compileApiErrorMsgDtl(Errors errors) {
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
