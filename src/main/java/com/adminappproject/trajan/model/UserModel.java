package com.adminappproject.trajan.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "ref_user")
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ref_user_has_ref_role", joinColumns = @JoinColumn(name = "ref_role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ref_user_id", referencedColumnName = "id"))
	private List<UserRoleModel> roles;

	public UserModel updateToModel(String updatedBy, DateTime updatedDate, String userName, String password,
			String alias) {
		super.setUpdatedBy(updatedBy);
		super.setUpdatedDate(updatedDate);
		this.username = userName;
		this.password = password;
		this.alias = alias;
		return this;
	}

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

	public List<UserRoleModel> getRoles() {
		return roles;
	}

	public UserModel setRoles(List<UserRoleModel> roles) {
		this.roles = roles;
		return this;
	}
	
}
