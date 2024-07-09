package com.iie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iie.model.UserRegister;

public interface AppRepository extends JpaRepository<UserRegister, Long> {
	Optional<UserRegister> findByUsername(String username);
	Optional<UserRegister> findByUsernameAndPassword(String username,String password);
	Optional<UserRegister> findById(int id);
	
}