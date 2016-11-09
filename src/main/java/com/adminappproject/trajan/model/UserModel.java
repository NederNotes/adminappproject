package com.adminappproject.trajan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ref_users")
public class UserModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "alias")
	private String alias;

	@OneToOne
	@JoinColumn(name = "ref_user_dtl_id")
	private UserDtlModel userDtl;

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

	public UserDtlModel getUserDtl() {
		return userDtl;
	}

	public void setUserDtl(UserDtlModel userDtl) {
		this.userDtl = userDtl;
	}

}
