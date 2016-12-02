package com.adminappproject.trajan.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.UserDtlModel;

public interface UserDtlRepo  extends PagingAndSortingRepository<UserDtlModel, Long> {

}
