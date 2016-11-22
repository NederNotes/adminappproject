package com.adminappproject.trajan.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiErrorFormDTO {

    private HttpStatus status = HttpStatus.OK;
    private Boolean errorFlag = false;
    private List<ApiErrorFormDtlDTO> apiErrorDtls;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Boolean getErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(Boolean errorFlag) {
        this.errorFlag = errorFlag;
    }

    public List<ApiErrorFormDtlDTO> getApiErrorDtls() {
        return apiErrorDtls;
    }

    public void setApiErrorDtls(List<ApiErrorFormDtlDTO> apiErrorDtls) {
        this.apiErrorDtls = apiErrorDtls;
    }
}
