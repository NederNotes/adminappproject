package com.adminappproject.trajan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ref_perm")
public class PermissionModel extends BaseModel{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy="permissions")
	private List<UserRoleModel> roles;

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

	public List<UserRoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoleModel> roles) {
		this.roles = roles;
	}
	
}
