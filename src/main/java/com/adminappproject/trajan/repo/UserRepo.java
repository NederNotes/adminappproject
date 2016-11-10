package com.adminappproject.trajan.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.UserModel;

@Transactional
public interface UserRepo extends PagingAndSortingRepository<UserModel, Long> {

}
