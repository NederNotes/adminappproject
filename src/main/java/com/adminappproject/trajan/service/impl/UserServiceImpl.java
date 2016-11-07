package com.adminappproject.trajan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adminappproject.trajan.model.UserModel;
import com.adminappproject.trajan.repo.UserRepo;
import com.adminappproject.trajan.service.UserService;

@Component(value="userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public String getUser() {
		Long id = 1L;
		
		UserModel userModel = userRepo.findOne(id);
		
		return userModel.getAlias();
	}

}
