package com.adminappproject.trajan.controller.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminappproject.trajan.controller.UserServiceController;
import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.service.UserService;
import com.adminappproject.trajan.validator.UserValidator;

@RestController
@RequestMapping(value = "/user")
public class UserServiceControllerImpl implements UserServiceController {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceControllerImpl.class);

	@Autowired
	private UserService userService;
	
	@Override
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getById(@RequestParam("userId") Long userId) {
		logger.info("Get user by Id : {}", userId);
		return new ResponseEntity<UserDTO>(userService.getUserById(userId), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO userDTO, BindingResult result) {
		logger.info("Create user: {}", userDTO);
		UserValidator.getValidator().validate(userDTO, result);
		if(!result.hasErrors()) {
			userService.saveUser(userDTO);
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);	
		} else {
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable("userId") Long userId) {
		logger.info("Update user : {}", userId, userDTO);
		userService.updateUser(userDTO, userId);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Page<UserDTO> getPage(Pageable pageable) {
		logger.info("Fetch users by page : {}", pageable);
		return userService.getUsers(pageable);
	}
}
