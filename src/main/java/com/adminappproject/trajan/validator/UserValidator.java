package com.adminappproject.trajan.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.adminappproject.trajan.dto.ApiError;
import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.service.ErrorHandlerService;

@Component
public class UserValidator implements Validator {

	private String MIDDLE_NAME_EMPTY = "err.msg.missing.req.value";
	
	@Autowired
	private ErrorHandlerService errorHandler;
	
	@Autowired 
    private MessageSource messageSource;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				messageSource.getMessage(MIDDLE_NAME_EMPTY, null, Locale.ENGLISH));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				messageSource.getMessage(MIDDLE_NAME_EMPTY, null, Locale.ENGLISH));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alias",
				messageSource.getMessage(MIDDLE_NAME_EMPTY, null, Locale.ENGLISH));
		embeddedErrorMsg(target, errors);
	}
	
	private void embeddedErrorMsg(Object target,  Errors errors) {
		if(errors.hasErrors()) {
			ApiError apiError = new ApiError();
			apiError.setStatus(HttpStatus.BAD_GATEWAY);
			apiError.setApiErrorDtls(errorHandler.compileErrorMsg(errors));
			((UserDTO)target).setApiError(apiError);
		}
	}
}
