package com.adminappproject.trajan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.adminappproject.trajan.dto.UserRoleDTO;

@Service
public interface UserRoleService {
	public UserRoleDTO getUserRoleById(Long userRoleId);
	public void saveRole(UserRoleDTO userRoleDTO);
	public void updateRole(UserRoleDTO userRoleDTO, Long userRoleId);
	public Page<UserRoleDTO> getUsers(Pageable pageable);
}
