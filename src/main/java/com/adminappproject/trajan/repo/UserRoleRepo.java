package com.adminappproject.trajan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.adminappproject.trajan.model.UserRoleModel;

public interface UserRoleRepo extends PagingAndSortingRepository<UserRoleModel, Long> {
	@Query("select roles from UserRoleModel roles where id in :userRoleIds")
	List<UserRoleModel> findByIds(@Param(value = "userRoleIds") List<Long> userRoleIds);
}
