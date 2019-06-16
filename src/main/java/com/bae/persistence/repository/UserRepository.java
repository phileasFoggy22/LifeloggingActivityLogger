package com.bae.persistence.repository;

public interface UserRepository {
	// Create
	String createUser(String userJSON);

	// Read
	String getUser(String userEmail);

	String getAllUsers();

	// Update
	String updateUser(String userJSON, String userEmail);

	// Delete
	String deleteUser(String userEmail);
}
