package com.adminappproject.trajan.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminappproject.trajan.model.UserDtlModel;

@Transactional
public interface UserDtlRepo  extends JpaRepository<UserDtlModel, Long> {

}
