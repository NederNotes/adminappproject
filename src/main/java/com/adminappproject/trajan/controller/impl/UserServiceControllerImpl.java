package com.adminappproject.trajan.controller.impl;

import com.adminappproject.trajan.controller.UserServiceController;
import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.service.UserService;
import com.adminappproject.trajan.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserServiceControllerImpl implements UserServiceController {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceControllerImpl.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@Override
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getById(@RequestParam("userId") Long userId) {
		logger.info("Get user by Id : {}", userId);
		return new ResponseEntity<UserDTO>(userService.getById(userId), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO userDTO, BindingResult result) {
		logger.info("Create user: {}", userDTO);
		userValidator.validate(userDTO, result);
		if (!result.hasErrors()) {
			userService.save(userDTO);
		}
		return new ResponseEntity<UserDTO>(userDTO, userDTO.getApiError().getStatus());
	}

	@Override
	@RequestMapping(value = "/update/{userId}", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable("userId") Long userId) {
		logger.info("Update user : {}", userId, userDTO);
		userService.update(userDTO, userId);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Page<UserDTO> getPage(Pageable pageable) {
		logger.info("Fetch users by page : {}", pageable);
		return userService.getPage(pageable);
	}
	
	@Override
	@RequestMapping(value = "/saveUserWithRoles", method = RequestMethod.POST)
	public  ResponseEntity<UserDTO> saveUserWithRoles(@RequestParam("userId") Long userId, @RequestParam("userRoleIds") List<Long> roleId) {
		logger.info("Save user with role by id : {}", userId, roleId);
		return new ResponseEntity<UserDTO>(userService.saveUserWithRoles(userId, roleId), HttpStatus.OK);
	}
}
