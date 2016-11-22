package com.adminappproject.trajan.service.impl;

import com.adminappproject.trajan.dto.ApiErrorFormDTO;
import com.adminappproject.trajan.dto.ApiErrorFormDtlDTO;
import com.adminappproject.trajan.service.ApiErrorService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component(value = "apiErrorFormServiceImpl")
public class ApiErrorFormServiceImpl implements ApiErrorService<ApiErrorFormDTO, Errors> {

	@Override
	public ApiErrorFormDTO compileApiErrorMsg(Errors errors, HttpStatus httpStatus) {
		ApiErrorFormDTO apiError = new ApiErrorFormDTO();
		apiError.setStatus(httpStatus);
		apiError.setErrorFlag(Boolean.TRUE);
		apiError.setApiErrorDtls(compileApiErrorMsgDtl(errors));
		return apiError;
	}

	private List<ApiErrorFormDtlDTO> compileApiErrorMsgDtl(Errors errors) {
		List<ApiErrorFormDtlDTO> apiErrorDtls = new ArrayList<>();
		List<FieldError> errorFields = errors.getFieldErrors();

		for (FieldError fieldError : errorFields) {
			ApiErrorFormDtlDTO apiErrorDtl = new ApiErrorFormDtlDTO();
			apiErrorDtl.setMessage(fieldError.getCode());
			apiErrorDtl.setRejectedValue(fieldError.getRejectedValue().toString());
			apiErrorDtl.setErrorsField(fieldError.getField());

			apiErrorDtls.add(apiErrorDtl);
		}
		return apiErrorDtls;
	}
}
