package com.adminappproject.trajan.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status =  HttpStatus.OK;
	private List<ApiErrorDtl> apiErrorDtls;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<ApiErrorDtl> getApiErrorDtls() {
		return apiErrorDtls;
	}

	public void setApiErrorDtls(List<ApiErrorDtl> apiErrorDtls) {
		this.apiErrorDtls = apiErrorDtls;
	}

}
