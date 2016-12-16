package com.adminappproject.trajan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.adminappproject.trajan.dto.UserRoleDTO;
import com.adminappproject.trajan.model.PermissionModel;
import com.adminappproject.trajan.model.UserRoleModel;
import com.adminappproject.trajan.repo.PermissionRepo;
import com.adminappproject.trajan.repo.UserRoleRepo;
import com.adminappproject.trajan.service.UserRoleService;

@Component(value = "userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService{

	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	@Autowired
	private PermissionRepo permissionRepo;
	
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
	
	@Override
	public UserRoleDTO saveRoleWithPerms(Long userRoleId, List<Long> permIds) {
		List<PermissionModel> permissionModels = new ArrayList<PermissionModel>();
		if (userRoleRepo.exists(userRoleId)) {
			UserRoleModel userRoleModel = userRoleRepo.findOne(userRoleId);
			permissionModels = permissionRepo.findByIds(permIds);
			return modelMapper.map(userRoleRepo.save(userRoleModel.setPermissions(permissionModels)), UserRoleDTO.class);
		}
		return modelMapper.map(new UserRoleModel(), UserRoleDTO.class);
	}

}
