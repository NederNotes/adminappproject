package com.adminappproject.trajan.dto;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("createdDate")
	private DateTime createdDate;

	@JsonProperty("updatedBy")
	private String updatedBy;

	@JsonProperty("updatedDate")
	private DateTime updatedDate;

	private ApiError apiError;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public DateTime getCreatedDate() {
		return this.id != null ? this.createdDate : DateTime.now();
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public DateTime getUpdatedDate() {
		return this.updatedDate != null ? this.updatedDate : DateTime.now();
	}

	public ApiError getApiError() {
		return apiError;
	}

	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}
}
