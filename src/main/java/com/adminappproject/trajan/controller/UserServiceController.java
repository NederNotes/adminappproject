package com.adminappproject.trajan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
