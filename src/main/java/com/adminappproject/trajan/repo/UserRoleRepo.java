package com.adminappproject.trajan.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.UserRoleModel;

public interface UserRoleRepo extends PagingAndSortingRepository<UserRoleModel, Long> {

}
