package com.adminappproject.trajan.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ref_user")
public class UserModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "disabled", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean disabled;

	@OneToOne
	@JoinColumn(name = "ref_user_dtl_id")
	private UserDtlModel userDtl;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ref_user_has_ref_role", joinColumns = @JoinColumn(name = "ref_user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ref_role_id", referencedColumnName = "id"))
	private List<UserRoleModel> roles;

	public UserModel updateToModel(String updatedBy, DateTime updatedDate, String userName, String password,
			String emailAddress, Boolean disabled) {
		super.setUpdatedBy(updatedBy);
		super.setUpdatedDate(updatedDate);
		this.username = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.disabled = disabled;
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
