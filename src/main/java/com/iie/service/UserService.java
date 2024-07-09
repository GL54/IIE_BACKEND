package com.iie.service;

import java.util.Optional;

import com.iie.model.UserRegister;

public interface UserService {

	UserRegister registerUser(UserRegister userRegister);

	boolean validateUser(String username, String password);
	
	Optional<UserRegister> user(String username,String password);
	Optional<UserRegister> useriD(int id);

}
