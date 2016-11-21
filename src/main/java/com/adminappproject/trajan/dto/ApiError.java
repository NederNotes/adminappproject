package com.adminappproject.trajan.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiError {

    private HttpStatus status = HttpStatus.OK;
    private Boolean errorFlag = false;
    private String generalMsg;
    private List<ApiErrorDtl> apiErrorDtls;

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

    public String getGeneralMsg() {
        return generalMsg;
    }

    public void setGeneralMsg(String generalMsg) {
        this.generalMsg = generalMsg;
    }

    public List<ApiErrorDtl> getApiErrorDtls() {
        return apiErrorDtls;
    }

    public void setApiErrorDtls(List<ApiErrorDtl> apiErrorDtls) {
        this.apiErrorDtls = apiErrorDtls;
    }
}
