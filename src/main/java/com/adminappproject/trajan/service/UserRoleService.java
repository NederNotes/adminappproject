package com.adminappproject.trajan.service;

import org.springframework.stereotype.Service;

import com.adminappproject.trajan.dto.UserRoleDTO;

@Service
public interface UserRoleService {
	public void saveRole(UserRoleDTO userRoleDTO);
	public void updateRole(UserRoleDTO userRoleDTO);
}
