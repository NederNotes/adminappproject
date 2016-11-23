package com.adminappproject.trajan.service.impl;


import com.adminappproject.trajan.dto.ApiErrorExceptionDTO;
import com.adminappproject.trajan.service.ApiErrorService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component(value = "apiErrorExceptionServiceImpl")
public class ApiErrorExceptionServiceImpl implements ApiErrorService<ApiErrorExceptionDTO, Exception> {

    @Override
    public ApiErrorExceptionDTO compileApiErrorMsg(Exception errors, HttpStatus httpStatus) {
        ApiErrorExceptionDTO apiErrorExceptionDTO = new ApiErrorExceptionDTO();
        apiErrorExceptionDTO.setHttpStatus(httpStatus);
        apiErrorExceptionDTO.setGeneralMsg(ExceptionUtils.getRootCauseMessage(errors));
        return apiErrorExceptionDTO;
    }

}
