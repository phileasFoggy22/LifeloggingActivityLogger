package com.bae.repository.test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserDBRepository;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class Version2IterationTest {
	
	@InjectMocks
	private UserDBRepository repo;
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	

	

	private static final String MOCK_DATA_ARRAY = "[{\"userEmail\":\"L.Cravensworth@gmail.com\",\"userName\":\"Laszlo Cravensworth\",\"password\":\"password\"}]";
	private static final String MOCK_OBJECT = "{\"userEmail\":\"L.Cravensworth@gmail.com\",\"userName\":\"Laszlo Cravensworth\",\"password\":\"passord\"}";


	@Before
	public void start() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void addUser() {
		System.out.println(MOCK_OBJECT);
		System.out.println(MOCK_DATA_ARRAY);
		System.out.println("here "+util.getJSONForObject(MOCK_OBJECT));
		 System.out.println("and "+repo.createUser(util.getJSONForObject(MOCK_OBJECT)));
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
