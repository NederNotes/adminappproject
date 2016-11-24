package com.adminappproject.trajan.controller;

import org.springframework.http.ResponseEntity;

import com.adminappproject.trajan.dto.UserDTO;

public interface UserServiceController extends BaseController<UserDTO> {
	public  ResponseEntity<UserDTO> saveUserWithRoles(Long userId, Long roleId);
}
