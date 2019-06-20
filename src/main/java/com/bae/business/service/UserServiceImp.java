package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.UserRepository;

public class UserServiceImp implements UserService {

	@Inject
	private UserRepository userRepo;

	@Override
	public String createUser(String userJSON) {
		return userRepo.createUser(userJSON);
	}

	@Override
	public String getUser(String userEmail) {
		return userRepo.getUser(userEmail);
	}

	@Override
	public String updateUser(String userEmail, String userJSON) {
		return userRepo.updateUser(userJSON, userEmail);
	}

	@Override
	public String deleteUser(String userEmail) {
		return userRepo.deleteUser(userEmail);
	}

	@Override
	public String getAllUsers() {
		return userRepo.getAllUsers();
	}

	public void setRepository(UserRepository userRepo) {
		this.userRepo = userRepo;

	}

}
