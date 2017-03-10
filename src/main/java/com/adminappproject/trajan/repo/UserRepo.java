package com.adminappproject.trajan.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.adminappproject.trajan.model.UserModel;

public interface UserRepo extends PagingAndSortingRepository<UserModel, Long> {	
	public UserModel findByUsername(String username);
}
