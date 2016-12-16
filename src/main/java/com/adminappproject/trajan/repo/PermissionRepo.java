package com.adminappproject.trajan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.adminappproject.trajan.model.PermissionModel;

public interface PermissionRepo extends PagingAndSortingRepository<PermissionModel, Long> {
	@Query("select permissions from PermissionModel permissions where id in :permIds")
	List<PermissionModel> findByIds(@Param(value = "permIds") List<Long> permIds);
}
