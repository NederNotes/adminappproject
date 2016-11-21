package com.adminappproject.trajan.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.model.UserModel;
import com.adminappproject.trajan.repo.UserDtlRepo;
import com.adminappproject.trajan.repo.UserRepo;
import com.adminappproject.trajan.service.UserService;

@Component(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserDtlRepo userDtlRepo;

	@Override
	public UserDTO getById(Long userId) {
		return modelMapper.map(userRepo.findOne(userId) != null
				? userRepo.findOne(userId) : new UserModel() , UserDTO.class);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserModel userModel = modelMapper.map(userDTO, UserModel.class);
		userModel.setUserDtl(userDtlRepo.save(userModel.getUserDtl()));
		userRepo.save(userModel);
		return userDTO;
	}

	@Override
	public UserDTO update(UserDTO userDTO, Long userId) {
		/*
		 * Use of ModelMapper to update is still experimental and number of code lines to be created is not advisable
		*/
		if (userRepo.exists(userId)) {
			UserModel userModel = updateDataDtoToModel(userDTO, userRepo.findOne(userId));
			userRepo.save(userModel);
		}
		return userDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<UserDTO> getPage(Pageable pageable) {
		return modelMapper.map(userRepo.findAll(pageable), Page.class);
	}
	
	private UserModel updateDataDtoToModel(UserDTO userDTO, UserModel userModel) {
		userModel.updateToModel(userDTO.getUpdatedBy(), userDTO.getUpdatedDate(), userDTO.getUsername(),
				userDTO.getPassword(), userDTO.getAlias());
		userModel.getUserDtl().updateToModel(userDTO.getUserDtl().getFirstName(), userDTO.getUserDtl().getMiddleName(),
				userDTO.getUserDtl().getLastName(), userDTO.getUserDtl().getGender(),
				userDTO.getUserDtl().getBirthDate());
		return userModel;
	}

}
