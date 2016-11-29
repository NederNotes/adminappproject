package com.adminappproject.trajan.controller.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminappproject.trajan.controller.PermissionServiceController;
import com.adminappproject.trajan.dto.PermissionDTO;

@RestController
@RequestMapping(value = "/permission")
public class PermissionServiceControllerImpl implements PermissionServiceController {

	@Override
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<PermissionDTO> getById(@RequestParam("permId") Long permId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<PermissionDTO> create(@RequestBody PermissionDTO dto, BindingResult result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/{permId}", method = RequestMethod.PUT)
	public ResponseEntity<PermissionDTO> update(@RequestBody PermissionDTO permissionDTO, @RequestParam("permId") Long permId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Page<PermissionDTO> getPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
