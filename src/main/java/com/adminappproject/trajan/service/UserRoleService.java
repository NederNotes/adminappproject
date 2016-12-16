package com.adminappproject.trajan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adminappproject.trajan.dto.UserRoleDTO;

@Service
public interface UserRoleService extends BaseService<UserRoleDTO>{
	public UserRoleDTO saveRoleWithPerms(Long userRoleId, List<Long> permIds);
}
