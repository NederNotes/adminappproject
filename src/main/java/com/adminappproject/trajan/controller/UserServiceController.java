package com.adminappproject.trajan.controller;

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

import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserServiceController {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserById(@RequestParam("userId") Long userId) {
		logger.info("Get user by Id : {}", userId);
		return new ResponseEntity<UserDTO>(userService.getUserById(userId), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		logger.info("Get user by Id : {}", userDTO);
		userService.saveUser(userDTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("userId") Long userId) {
		logger.info("Get user by Id : {}", userId, userDTO);
		userService.updateUser(userDTO, userId);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Page<UserDTO> getUsers(Pageable pageable) {
		logger.info("Get users by page : {}", pageable);
		return userService.getUsers(pageable);
	}
}
