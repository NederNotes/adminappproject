package com.adminappproject.trajan.service.impl;

import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.model.UserModel;
import com.adminappproject.trajan.model.UserRoleModel;
import com.adminappproject.trajan.repo.UserDtlRepo;
import com.adminappproject.trajan.repo.UserRepo;
import com.adminappproject.trajan.repo.UserRoleRepo;
import com.adminappproject.trajan.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
	public UserDTO getById(Long id) {
		return updateDataModelToDto(userRepo.findOne(id) );
	}

	@Override
	public UserDTO save(UserDTO dto) {
		UserModel userModel = updateDataDtoToModel(dto);
		userModel.setUserDtl(userDtlRepo.save(userModel.getUserDtl()));
		return modelMapper.map(userRepo.save(userModel),UserDTO.class);
	}

	@Override
	public UserDTO update(UserDTO dto, Long id) {
		/*
		 * Use of ModelMapper to update is still experimental due to value override
		 * also lines of code to be created is not advisable
		 */
		if (userRepo.exists(id)) {
			UserModel userModel = updateDataDtoToModelRaw(dto, userRepo.findOne(id));
			return modelMapper.map(userRepo.save(userModel),UserDTO.class);
		}
		return dto;
	}

	@Override
	public Page<UserDTO> getPage(Pageable pageable) {
		return modelMapper.map(userRepo.findAll(pageable), Page.class);
	}

	@Override
	public UserDTO saveUserWithRoles(Long userId, List<Long> roleId) {
		List<UserRoleModel> userRoleModels = new ArrayList<UserRoleModel>();
		if (userRepo.exists(userId)) {
			UserModel userModel = userRepo.findOne(userId);
			userRoleModels = userRoleRepo.findByIds(roleId);
			return updateDataModelToDto(userModel.setRoles(userRoleModels));
		}
		return updateDataModelToDto(new UserModel());
	}

	@Override
	public UserDTO findByUsername(String username) {
		return updateDataModelToDto(userRepo.findByUsername(username));
	}

	private UserModel updateDataDtoToModelRaw(UserDTO userDTO, UserModel userModel) {
		userModel.updateToModel(userDTO.getUpdatedBy(), userDTO.getUpdatedDate(), userDTO.getUsername(),
				userDTO.getPassword(), userDTO.getEmailAddress(), userDTO.isDisabled());
		userModel.getUserDtl().updateToModel(userDTO.getUserDtl().getFirstName(), userDTO.getUserDtl().getMiddleName(),
				userDTO.getUserDtl().getLastName(), userDTO.getUserDtl().getGender(),
				userDTO.getUserDtl().getBirthDate(), userDTO.getUserDtl().getAlias());
		return userModel;
	}

	private UserDTO updateDataModelToDto(UserModel userModel) {
		return  modelMapper.map(userModel != null ? userModel : new UserModel() , UserDTO.class);
	}

	private UserModel updateDataDtoToModel(UserDTO userDTO) {
		return  modelMapper.map(userDTO, UserModel.class);
	}

}
