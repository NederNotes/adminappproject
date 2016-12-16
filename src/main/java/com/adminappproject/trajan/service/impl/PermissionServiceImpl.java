package com.adminappproject.trajan.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.adminappproject.trajan.dto.PermissionDTO;
import com.adminappproject.trajan.model.PermissionModel;
import com.adminappproject.trajan.repo.PermissionRepo;
import com.adminappproject.trajan.service.PermissionService;

@Component(value = "permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService{

	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private PermissionRepo permissionRepo;
	
	@Override
	public PermissionDTO getById(Long permId) {
		return modelMapper.map(permissionRepo.findOne(permId) != null 
				? permissionRepo.findOne(permId) : new PermissionDTO(), PermissionDTO.class);
	}

	@Override
	public PermissionDTO save(PermissionDTO permissionDTO) {
		permissionRepo.save(modelMapper.map(permissionDTO, PermissionModel.class));
		return permissionDTO;
	}

	@Override
	public PermissionDTO update(PermissionDTO permissionDTO, Long permId) {
		if (permissionRepo.exists(permId)) {
			PermissionModel permissionModel = updateDataDtoToModel(permissionDTO, permissionRepo.findOne(permId));
			permissionRepo.save(permissionModel);
		}
		return permissionDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<PermissionDTO> getPage(Pageable pageable) {
		return modelMapper.map(permissionRepo.findAll(pageable), Page.class);
	}
	
	private PermissionModel updateDataDtoToModel(PermissionDTO permissionDTO, PermissionModel permissionModel) {
		permissionModel.updateToModel(permissionDTO.getUpdatedBy(), permissionDTO.getUpdatedDate(), permissionDTO.getName()
				, permissionDTO.getCode(), permissionDTO.getDescription());
		return permissionModel;
	}
}
