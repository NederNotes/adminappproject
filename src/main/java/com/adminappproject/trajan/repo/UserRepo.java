package com.adminappproject.trajan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.adminappproject.trajan.model.UserModel;

public interface UserRepo extends PagingAndSortingRepository<UserModel, Long> {
	
	/*@Query(" SELECT user FROM UserModel AS user ")
	Page<UserModel> findAllUser(Pageable pageable);*/
	
	@Query(" SELECT user FROM UserModel AS user where user.username = :username")
	public UserModel findByUsername(@Param(value = "username") String username);
}
