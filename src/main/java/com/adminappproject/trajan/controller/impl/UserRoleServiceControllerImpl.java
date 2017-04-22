package com.adminappproject.trajan.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<UserRoleDTO> getById(@RequestParam("userRoleId") Long userRoleId) {
		logger.info("Get user role by Id : {}", userRoleId);
		return new ResponseEntity<UserRoleDTO>(userRoleService.getById(userRoleId), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<UserRoleDTO> create(@RequestBody UserRoleDTO userRoleDTO, BindingResult result) {
		logger.info("Create user role: {}", userRoleDTO);
		return new ResponseEntity<UserRoleDTO>(userRoleService.save(userRoleDTO), HttpStatus.OK);
	}
	@Override
	@RequestMapping(value = "/update/{userRoleId}", method = RequestMethod.POST)
	public ResponseEntity<UserRoleDTO> update(@RequestBody UserRoleDTO userRoleDTO, @PathVariable("userRoleId") Long userRoleId) {
		logger.info("Update user role : {}", userRoleId, userRoleDTO);
		return new ResponseEntity<UserRoleDTO>(userRoleService.update(userRoleDTO, userRoleId), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Page<UserRoleDTO> getPage(Pageable pageable) {
		logger.info("Fetch users roles by page : {}", pageable);
		return userRoleService.getPage(pageable);
	}
	
	@Override
	@RequestMapping(value = "/saveRoleWithPerms", method = RequestMethod.POST)
	public  ResponseEntity<UserRoleDTO> saveRoleWithPerms(@RequestParam("userRoleId") Long userRoleId, @RequestParam("permIds") List<Long> permIds) {
		logger.info("Save user with role by id : {}", userRoleId, permIds);
		return new ResponseEntity<UserRoleDTO>(userRoleService.saveRoleWithPerms(userRoleId, permIds), HttpStatus.OK);
	}

}
