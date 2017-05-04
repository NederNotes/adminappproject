package com.adminappproject.trajan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;

@Entity
@Table(name = "ref_role")
public class UserRoleModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;
	
	@Transient
	private List<UserModel> users;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ref_role_has_ref_perm", joinColumns = @JoinColumn(name = "ref_role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ref_perm_id", referencedColumnName = "id"))
	private List<PermissionModel> permissions;
	
	public UserRoleModel updateToModel(String updatedBy, DateTime updatedDate, String name, String code, String description) {
		this.setUpdatedBy(updatedBy);
		this.setUpdatedDate(updatedDate);
		this.name = name;
		this.code = code;
		this.description = description;		
		return this;
	}

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

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

	public List<PermissionModel> getPermissions() {
		return permissions;
	}

	public UserRoleModel setPermissions(List<PermissionModel> permissions) {
		this.permissions = permissions;
		return this;
	}
}
