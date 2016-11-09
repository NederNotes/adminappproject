package com.adminappproject.trajan.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.model.UserModel;
import com.adminappproject.trajan.repo.UserDtlRepo;
import com.adminappproject.trajan.repo.UserRepo;
import com.adminappproject.trajan.service.UserService;

@Component(value="userServiceImpl")
public class UserServiceImpl implements UserService{
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserDtlRepo userDtlRepo;

	@Override
	public UserDTO getUserById(Long userId) {
		return modelMapper.map(userRepo.findOne(userId), UserDTO.class);
	}

	@Override
	public void saveUser(UserDTO userDTO) {
		
		UserModel userModel = modelMapper.map(userDTO, UserModel.class);
		
		userModel.setUserDtl(userDtlRepo.save(userModel.getUserDtl()));
		userRepo.save(userModel);
	}

}
