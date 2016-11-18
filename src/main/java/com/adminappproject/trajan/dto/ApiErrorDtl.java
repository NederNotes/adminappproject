package com.adminappproject.trajan.dto;

public class ApiErrorDtl {
	private String message;
	private String errorsField;
	private String rejectedValue;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorsField() {
		return errorsField;
	}

	public void setErrorsField(String errorsField) {
		this.errorsField = errorsField;
	}

	public String getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(String rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

}
