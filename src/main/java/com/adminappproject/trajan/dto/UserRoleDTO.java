package com.adminappproject.trajan.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRoleDTO extends BaseDTO {

	@JsonProperty("name")
	private String name;

	@JsonProperty("code")
	private String code;

	@JsonProperty("description")
	private String description;

	@JsonProperty("permission")
	private List<PermissionDTO> permission;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PermissionDTO> getPermission() {
		return permission;
	}

	public void setPermission(List<PermissionDTO> permission) {
		this.permission = permission;
	}

}
