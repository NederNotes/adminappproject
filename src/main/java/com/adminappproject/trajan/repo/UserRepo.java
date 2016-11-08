package com.adminappproject.trajan.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminappproject.trajan.model.UserModel;

@Transactional
public interface UserRepo extends JpaRepository<UserModel, Long> {

}
