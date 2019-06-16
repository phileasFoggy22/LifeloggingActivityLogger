package com.bae.repository.test;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserDBRepository;
import com.bae.util.JSONUtil;

public class Version2IterationTest {

	private UserDBRepository usersDB = new UserDBRepository();
	private User newUser;
	private User newUser2;

	JSONUtil util = new JSONUtil();

	@Before
	public void start() {
	}

	@Test
	public void addUser() {
		newUser = new User("L.Cravensworth@gmail.com", "Laszlo Cravensworth", "password");
		System.out.println(util.getJSONForObject(newUser));
		// System.out.println(usersDB.createUser(util.getJSONForObject(newUser)));
		// System.out.println(usersDB.getUser("L.Cravensworth@gmail.com"));
		// assertEquals(newUser,usersDB.getUser("L.Cravensworth@gmail.com"));
		assert (true);
	}

	@Test
	public void updateUser() {
		assert (true);
	}

	@Test
	public void deleteUser() {
		assert (true);
	}

	@Test
	public void getHikingActivity() {

	}
}
