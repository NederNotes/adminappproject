package com.adminappproject.trajan.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.adminappproject.trajan.dto.UserDTO;

public interface UserServiceController extends BaseCrudController<UserDTO> {
	public  ResponseEntity<UserDTO> saveUserWithRoles(Long userId, List<Long> roleIds);
}
