package com.adminappproject.trajan.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Brian.Lee on 4/10/2017.
 */
@RestController
@RequestMapping(value = "")
public class SignInServiceControllerImpl {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> fetchLogin(HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> userLogin(HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity<String>("Logged In", HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<String> userLogout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session= request.getSession(false);
        SecurityContextHolder.clearContext();
        session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }
        return new ResponseEntity<String>("Sucessful Logout", HttpStatus.OK);
    }

    @RequestMapping(value = "/getLoggedUser", method = RequestMethod.GET)
    public ResponseEntity<User> getLoggedUser(@AuthenticationPrincipal User activeUser) {
        return new ResponseEntity<User>(activeUser, HttpStatus.OK);
    }
}
