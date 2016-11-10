package com.adminappproject.trajan.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import com.adminappproject.trajan.dto.UserDTO;

public interface UserServiceController {
	public ResponseEntity<UserDTO> getUserById(Long userId);
	public ResponseEntity<UserDTO> createUser(UserDTO userDTO);
	public ResponseEntity<UserDTO> updateUser(UserDTO userDTO, Long userId);
	public Page<UserDTO> getUsers(Pageable pageable);
}
