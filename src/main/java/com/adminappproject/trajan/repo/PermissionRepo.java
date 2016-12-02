package com.adminappproject.trajan.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.PermissionModel;

public interface PermissionRepo extends PagingAndSortingRepository<PermissionModel, Long> {

}
