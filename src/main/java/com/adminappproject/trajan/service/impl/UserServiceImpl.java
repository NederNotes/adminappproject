package com.adminappproject.trajan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.model.UserModel;
import com.adminappproject.trajan.model.UserRoleModel;
import com.adminappproject.trajan.repo.UserDtlRepo;
import com.adminappproject.trajan.repo.UserRepo;
import com.adminappproject.trajan.repo.UserRoleRepo;
import com.adminappproject.trajan.service.UserService;

@Component(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserDtlRepo userDtlRepo;

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Override
	public UserDTO getById(Long userId) {
		return modelMapper.map(userRepo.findOne(userId) != null ? userRepo.findOne(userId) : new UserModel() , UserDTO.class);
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
		 * Use of ModelMapper to update is still experimental and number of
		 * lines of code to be created is not advisable
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

	@Override
	public UserDTO saveUserWithRoles(Long userId, List<Long> roleId) {
		List<UserRoleModel> userRoleModels = new ArrayList<UserRoleModel>();
		if (userRepo.exists(userId)) {
			UserModel userModel = userRepo.findOne(userId);
			userRoleModels = userRoleRepo.findByIds(roleId);
			return modelMapper.map(userRepo.save(userModel.setRoles(userRoleModels)), UserDTO.class);
		}
		return modelMapper.map(new UserModel(), UserDTO.class);
	}

	@Override
	public UserDTO findByUsername(String username) {
		return updateDataModelToDto(userRepo.findByUsername(username));
	}
	
	private UserDTO updateDataModelToDto(UserModel userModel) {
		return  modelMapper.map(userModel != null ? userModel : new UserModel() , UserDTO.class);
	}

}
