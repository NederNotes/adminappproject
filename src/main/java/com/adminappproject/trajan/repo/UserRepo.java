package com.adminappproject.trajan.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.adminappproject.trajan.model.UserModel;

@Transactional
public interface UserRepo extends CrudRepository<UserModel, Long> {

}
