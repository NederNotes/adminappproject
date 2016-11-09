package com.adminappproject.trajan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO extends BaseDTO {

	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	@JsonProperty("alias")
	private String alias;

	@JsonProperty("userDtl")
	private UserDtlDTO userDtl;

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public UserDtlDTO getUserDtl() {
		return userDtl;
	}

	public void setUserDtl(UserDtlDTO userDtl) {
		this.userDtl = userDtl;
	}

}
