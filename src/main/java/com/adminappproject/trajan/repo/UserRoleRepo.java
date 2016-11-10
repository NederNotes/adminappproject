package com.adminappproject.trajan.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.UserRoleModel;

@Transactional
public interface UserRoleRepo extends PagingAndSortingRepository<UserRoleModel, Long> {

}
