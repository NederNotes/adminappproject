package com.adminappproject.trajan.controller.impl;

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

import com.adminappproject.trajan.controller.PermissionServiceController;
import com.adminappproject.trajan.dto.PermissionDTO;
import com.adminappproject.trajan.service.impl.PermissionServiceImpl;

@RestController
@RequestMapping(value = "/permission")
public class PermissionServiceControllerImpl implements PermissionServiceController {
	private static final Logger logger = LoggerFactory.getLogger(PermissionServiceControllerImpl.class);

	@Autowired
	private PermissionServiceImpl permissionServiceImpl;
	
	@Override
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<PermissionDTO> getById(@RequestParam("permId") Long permId) {
		logger.info("Get permission by Id : {}", permId);
		return new ResponseEntity<PermissionDTO>(permissionServiceImpl.getById(permId), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<PermissionDTO> create(@RequestBody PermissionDTO permissionDTO, BindingResult result) {
		logger.info("Create permission: {}", permissionDTO);
		return new ResponseEntity<PermissionDTO>(permissionServiceImpl.save(permissionDTO), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/{permId}", method = RequestMethod.PUT)
	public ResponseEntity<PermissionDTO> update(@RequestBody PermissionDTO permissionDTO, @PathVariable("permId") Long permId) {
		logger.info("Update permission : {}", permId, permissionDTO);
		return new ResponseEntity<PermissionDTO>(permissionServiceImpl.update(permissionDTO, permId), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Page<PermissionDTO> getPage(Pageable pageable) {
		logger.info("Fetch permission by page : {}", pageable);
		return permissionServiceImpl.getPage(pageable);
	}

}
