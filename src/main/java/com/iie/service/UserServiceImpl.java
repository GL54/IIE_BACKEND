package com.iie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.model.UserRegister;
import com.iie.repository.AppRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final AppRepository appRepository;

	public UserServiceImpl(AppRepository appRepository) {
		this.appRepository = appRepository;
	}

	@Override
	public UserRegister registerUser(UserRegister userRegister) {
		return appRepository.save(userRegister);
	}

	@Override
	public boolean validateUser(String username, String password) {
		return appRepository.findByUsername(username).map(user -> user.getPassword().equals(password)).orElse(false);
	}
	
	public Optional<UserRegister> user(String username, String password) {
		return appRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Optional<UserRegister> useriD(int id) {
		return appRepository.findById(id);
	};
}
