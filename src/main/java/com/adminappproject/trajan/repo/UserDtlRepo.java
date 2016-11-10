package com.adminappproject.trajan.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adminappproject.trajan.model.UserDtlModel;

@Transactional
public interface UserDtlRepo  extends PagingAndSortingRepository<UserDtlModel, Long> {

}
