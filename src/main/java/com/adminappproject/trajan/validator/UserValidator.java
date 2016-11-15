package com.adminappproject.trajan.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userDtl.middleName", "ERROR SHIZ");
	}
	
	public static UserValidator getValidator(){
		return new UserValidator();
	}
}
