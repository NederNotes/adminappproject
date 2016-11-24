package com.adminappproject.trajan.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.adminappproject.trajan.dto.UserRoleDTO;
import com.adminappproject.trajan.model.UserRoleModel;
import com.adminappproject.trajan.repo.UserRoleRepo;
import com.adminappproject.trajan.service.UserRoleService;

@Component(value = "userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService{

	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	@Override
	public UserRoleDTO getById(Long userRoleId) {
		return modelMapper.map(userRoleRepo.findOne(userRoleId) != null 
				? userRoleRepo.findOne(userRoleId) : new UserRoleDTO(), UserRoleDTO.class);
	}

	@Override
	public UserRoleDTO save(UserRoleDTO userRoleDTO) {
		userRoleRepo.save(modelMapper.map(userRoleDTO, UserRoleModel.class));
		return userRoleDTO;
	}

	@Override
	public UserRoleDTO update(UserRoleDTO userRoleDTO, Long userRoleId) {
		if (userRoleRepo.exists(userRoleId)) {
			UserRoleModel userRoleModel = updateDataDtoToModel(userRoleDTO, userRoleRepo.findOne(userRoleId));
			userRoleRepo.save(userRoleModel);
		}
		return userRoleDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<UserRoleDTO> getPage(Pageable pageable) {
		return modelMapper.map(userRoleRepo.findAll(pageable), Page.class);
	}
	
	private UserRoleModel updateDataDtoToModel(UserRoleDTO userRoleDTO, UserRoleModel userRoleModel) {
		userRoleModel.updateToModel(userRoleDTO.getUpdatedBy(), userRoleDTO.getUpdatedDate(), userRoleDTO.getName()
				, userRoleDTO.getCode(), userRoleDTO.getDescription());
		return userRoleModel;
	}

}
