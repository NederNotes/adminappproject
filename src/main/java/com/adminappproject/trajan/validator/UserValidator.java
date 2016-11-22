package com.adminappproject.trajan.validator;

import com.adminappproject.trajan.dto.ApiErrorFormDTO;
import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.service.ApiErrorService;
import com.adminappproject.trajan.service.PropertiesMessageService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private String MISSING_REQUIRED_FIELD = "err.msg.form.req.value.missing";

	@Resource(name="apiErrorFormServiceImpl")
    private ApiErrorService<ApiErrorFormDTO, Errors> apiErrorService;

    @Autowired
    private PropertiesMessageService propertiesMessageService;


    @Override
    public boolean supports(Class<?> arg0) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
                propertiesMessageService.getMessage(MISSING_REQUIRED_FIELD));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                propertiesMessageService.getMessage(MISSING_REQUIRED_FIELD));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alias",
                propertiesMessageService.getMessage(MISSING_REQUIRED_FIELD));
        embeddedErrorMsg(target, errors);
    }

	private void embeddedErrorMsg(Object target, Errors errors) {
        if (errors.hasErrors()) {
            ((UserDTO) target).setApiError((ApiErrorFormDTO)apiErrorService.compileApiErrorMsg(errors, HttpStatus.BAD_GATEWAY));
        }
    }
}
