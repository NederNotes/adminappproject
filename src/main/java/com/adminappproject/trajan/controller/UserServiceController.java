package com.adminappproject.trajan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {
	@RequestMapping("/greeting")
    public String greeting() {
        return "greetings";
    }
}
