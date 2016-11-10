package com.adminappproject.trajan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.adminappproject.trajan.dto.UserDTO;


@Service
public interface UserService {

	public UserDTO getUserById(Long userId);
	public void saveUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO, Long userId);
	public Page<UserDTO> getUsers(Pageable pageable);
	
}
