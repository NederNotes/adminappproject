package com.adminappproject.trajan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adminappproject.trajan.dto.UserDTO;

@Service
public interface UserService extends BaseService<UserDTO> {
	public UserDTO saveUserWithRoles(Long userId, List<Long> roleId);
}
