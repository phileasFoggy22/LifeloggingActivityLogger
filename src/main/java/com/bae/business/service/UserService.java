package com.bae.business.service;

public interface UserService {
	// Create
	String createUser(String userJSON);

	// Read
	String getUser(String userEmail);

	String getAllUsers();

	// Update
	String updateUser(String userEmail, String userJSON);

	// Delete
	String deleteUser(String userEmail);
}
