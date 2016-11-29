package com.adminappproject.trajan.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.PermissionModel;

@Transactional
public interface PermissionRepo extends PagingAndSortingRepository<PermissionModel, Long> {

}
