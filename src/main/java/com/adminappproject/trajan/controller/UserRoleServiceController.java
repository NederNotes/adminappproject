package com.adminappproject.trajan.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.adminappproject.trajan.dto.UserRoleDTO;

public interface UserRoleServiceController {
	public ResponseEntity<UserRoleDTO> createUserRole(UserRoleDTO userRoleDTO);
	public ResponseEntity<UserRoleDTO> getUserRoleById(Long userRoleId);
	public ResponseEntity<UserRoleDTO> updateUserRole(UserRoleDTO userRoleDTO, Long userRoleId);
	public Page<UserRoleDTO> getUserRoles(Pageable pageable);
	
}
