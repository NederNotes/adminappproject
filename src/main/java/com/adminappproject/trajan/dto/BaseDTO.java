package com.adminappproject.trajan.dto;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseDTO {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("updatedBy")
	private String updatedBy;
	
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
	public DateTime getCreatedDate() {
		return this.id == null ? DateTime.now() : null;
	}
	public DateTime getUpdatedDate() {
		return DateTime.now();
	}
	
		
}
