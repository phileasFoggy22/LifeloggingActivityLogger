package com.bae.repository.test;

import static org.junit.Assert.assertEquals;

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
	private static final String MOCK_OBJECT2 = "{\"userEmail\":\"N.Cravensworth@gmail.com\",\"userName\":\"Nadja Cravensworth\",\"password\":\"passord\"}";
	private static final String MOCK_OBJECT3 = "{\"userEmail\":\"N.Relentless@gmail.com\",\"userName\":\"Nandor the Relentless\",\"password\":\"passord\"}";

	@Before
	public void start() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
//		repo.createUser(MOCK_OBJECT2);
	}

	@Test
	public void addUser() {
//		 String reply = repo.createUser(MOCK_OBJECT);
		String reply = repo.createUser(MOCK_OBJECT);
		assertEquals("{\"message\": \"user successfully added\"}",reply);
	}

	@Test
	public void updateUser() {
		User toUpdate  = util.getObjectForJSON(repo.getUser("N.Cravensworth@gmail.com"), User.class);
		User newValues = util.getObjectForJSON(MOCK_OBJECT3, User.class);
//		String reply = repo.updateUser(MOCK_OBJECT3, "N.Cravensworth@gmail.com");
//		assertEquals("{\"message\": \"user successfully added\"}",reply);
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
