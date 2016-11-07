package com.adminappproject.trajan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ref_users")
public class UserModel extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="alias")
	private String alias;

	@Column(name="ref_user_dtl_id")
	private Long refUserDtl;

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

	public Long getRefUserDtl() {
		return refUserDtl;
	}

	public void setRefUserDtl(Long refUserDtl) {
		this.refUserDtl = refUserDtl;
	}

}
