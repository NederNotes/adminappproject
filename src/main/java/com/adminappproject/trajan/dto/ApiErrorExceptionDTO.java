package com.adminappproject.trajan.dto;

import org.springframework.http.HttpStatus;

public class ApiErrorExceptionDTO {

	private HttpStatus httpStatus = HttpStatus.OK;
	private String generalMsg;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getGeneralMsg() {
		return generalMsg;
	}

	public void setGeneralMsg(String generalMsg) {
		this.generalMsg = generalMsg;
	}
}
