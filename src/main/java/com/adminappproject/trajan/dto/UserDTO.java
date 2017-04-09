package com.adminappproject.trajan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserDTO extends BaseDTO {

	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	@JsonProperty("emailAddress")
	private String emailAddress;

	@JsonProperty("disabled")
	private Boolean disabled;

	@JsonProperty("userDtl")
	private UserDtlDTO userDtl;

	@JsonProperty("roles")
	private List<UserRoleDTO> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public UserDtlDTO getUserDtl() {
		return userDtl;
	}

	public void setUserDtl(UserDtlDTO userDtl) {
		this.userDtl = userDtl;
	}

	public List<UserRoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoleDTO> roles) {
		this.roles = roles;
	}

}
