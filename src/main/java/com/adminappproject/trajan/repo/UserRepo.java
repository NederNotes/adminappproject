package com.adminappproject.trajan.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.UserModel;

public interface UserRepo extends PagingAndSortingRepository<UserModel, Long> {
	
	@Query(" SELECT user FROM UserModel AS user ")
	Page<UserModel> findAllUser(Pageable pageable);
}
