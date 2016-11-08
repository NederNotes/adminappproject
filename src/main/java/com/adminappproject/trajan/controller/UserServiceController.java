package com.adminappproject.trajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserServiceController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
    public String greeting() {
        return userService.getUser();
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
}
