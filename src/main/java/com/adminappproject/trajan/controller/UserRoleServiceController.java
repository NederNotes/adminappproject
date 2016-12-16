package com.adminappproject.trajan.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.adminappproject.trajan.dto.UserRoleDTO;

public interface UserRoleServiceController extends BaseController<UserRoleDTO>{
	public  ResponseEntity<UserRoleDTO> saveRoleWithPerms(Long userRoleId, List<Long> permIds);
}
