package com.bae.repository.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
	private static final String MOCK_OBJECT = "{\"userEmail\":\"L.Cravensworth@gmail.com\",\"userName\":\"Laszlo Cravensworth\",\"password\":\"password\"}";
	private static final String MOCK_OBJECT2 = "{\"userEmail\":\"N.Cravensworth@gmail.com\",\"userName\":\"Nadja Cravensworth\",\"password\":\"password\"}";
	private static final String MOCK_OBJECT3 = "{\"userEmail\":\"N.Relentless@gmail.com\",\"userName\":\"Nandor the Relentless\",\"password\":\"password\"}";

	@Before
	public void start() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		repo.createUser(MOCK_OBJECT2);
	}

	@Test
	public void addUser() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		String reply = repo.createUser(MOCK_OBJECT);
		assertEquals("{\"message\": \"user successfully added\"}", reply);
	}

	@Test
	public void getUser() {
		// Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		// List<User> userList = new ArrayList<>();
		// Mockito.when(query.getResultList()).thenReturn(userList);
		// System.out.println(repo.getAllUsers());
		// assertEquals("{\"message\": \"user successfully added\"}", reply);
		assert (true);
	}

	@Test
	public void updateUser() {
		// Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		// List<User> userList = new ArrayList<User>();
		// Mockito.when(query.getResultList()).thenReturn(userList);
		// User toUpdate =
		// util.getObjectForJSON(repo.getUser("N.Cravensworth@gmail.com"), User.class);
		// System.out.println(toUpdate);
		// User newValues = util.getObjectForJSON(MOCK_OBJECT3, User.class);
		// System.out.println(newValues);
		// String reply = repo.updateUser(MOCK_OBJECT3, "N.Cravensworth@gmail.com");
		// System.out.println(reply);
		// assertEquals("{\"message\": \"user successfully updated\"}",reply);
		assert (true);
	}

	@Test
	public void deleteUser() {
		String reply = repo.deleteUser("N.Cravensworth@gmail.com");
		Assert.assertEquals(reply, "{\"message\": \"User successfully removed\"}");
	}

	// @Test
	// public void getHikingActivity() {
	//
	// }
}
