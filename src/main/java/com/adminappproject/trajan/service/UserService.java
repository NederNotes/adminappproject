package com.adminappproject.trajan.service;

import org.springframework.stereotype.Service;

import com.adminappproject.trajan.dto.UserDTO;


@Service
public interface UserService {

	public String getUser();
	public void saveUser(UserDTO userDTO);
	
}
