package com.adminappproject.trajan.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminappproject.trajan.controller.UserRoleServiceController;
import com.adminappproject.trajan.dto.UserRoleDTO;
import com.adminappproject.trajan.service.UserRoleService;

@RestController
@RequestMapping(value = "/role")
public class UserRoleServiceControllerImpl implements UserRoleServiceController {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceControllerImpl.class);
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Override
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<UserRoleDTO> getUserRoleById(@RequestParam("userRoleId") Long userRoleId) {
		logger.info("Get user role by Id : {}", userRoleId);
		return new ResponseEntity<UserRoleDTO>(userRoleService.getUserRoleById(userRoleId), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<UserRoleDTO> createUserRole(@RequestBody UserRoleDTO userRoleDTO) {
		logger.info("Create user role: {}", userRoleDTO);
		userRoleService.saveRole(userRoleDTO);
		return new ResponseEntity<UserRoleDTO>(userRoleDTO, HttpStatus.OK);
	}
	@Override
	@RequestMapping(value = "/{userRoleId}", method = RequestMethod.PUT)
	public ResponseEntity<UserRoleDTO> updateUserRole(@RequestBody UserRoleDTO userRoleDTO, @PathVariable("userRoleId") Long userRoleId) {
		logger.info("Update user role : {}", userRoleId, userRoleDTO);
		userRoleService.updateRole(userRoleDTO, userRoleId);
		return new ResponseEntity<UserRoleDTO>(userRoleDTO, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Page<UserRoleDTO> getUserRoles(Pageable pageable) {
		logger.info("Fetch users roles by page : {}", pageable);
		return userRoleService.getUsers(pageable);
	}

}
