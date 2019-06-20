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

import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserDBRepository;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserDBRepositoryTest {

	private static final String MOCK_VALUE3 = "test_value_3";
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private UserDBRepository userRepo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_OBJECT = "{test_value:value}";
	private static final String MOCK_OBJECT2 = "test_value";
	private static final String MOCK_DATA_ARRAY = "[{\"title\":\"Alien\",\"ageRating\":\"15\"}]";

	@Before
	public void setup() {
		userRepo.setManager(manager);
		util = new JSONUtil();
		userRepo.setUtil(util);
	}

	// @Test
	// public void testFetchAllUsers() {
	// // Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
	// // List<User> movies = new ArrayList<>();
	// // Mockito.when(query.getResultList()).thenReturn(movies);
	// // System.out.println(userRepo.getAllUsers());
	// // Assert.assertEquals(MOCK_DATA_ARRAY, userRepo.getAllUsers());
	//
	// User user = new User("N.Cravensworth@gmail.com", "Nadja Cravensworth",
	// "Password");
	// Mockito.when(manager.find(Mockito.any(),
	// Mockito.anyString())).thenReturn(user);
	// assertEquals(
	// "{\"userEmail\":\"N.Cravensworth@gmail.com\",\"userName\":\"Nadja
	// Cravensworth\",\"userPassword\":\"Password\",\"activityList\":[]}",
	// userRepo.getAllUsers());
	//
	// }

	@Test
	public void testCreateUser() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		String reply = userRepo.createUser(MOCK_OBJECT);
		assertEquals("{\"message\": \"user successfully added\"}", reply);
	}

	@Test
	public void testRemoveUser() {
		String reply = userRepo.deleteUser(MOCK_VALUE2);
		Assert.assertEquals(reply, "{\"message\": \"User sucessfully removed\"}");
	}

	@Test
	public void testGetUser() {
		User user = new User("N.Cravensworth@gmail.com", "Nadja Cravensworth", "Password");
		Mockito.when(manager.find(Mockito.any(), Mockito.anyString())).thenReturn(user);
		assertEquals(
				"{\"userEmail\":\"N.Cravensworth@gmail.com\",\"userName\":\"Nadja Cravensworth\",\"userPassword\":\"Password\",\"activityList\":[]}",
				userRepo.getUser("N.Cravensworth@gmail.com"));
	}

	@Test
	public void testUpdateUser() {
		User user = new User("N.Cravensworth@gmail.com", "Nadja Cravensworth", "Password");
		Mockito.when(manager.find(Mockito.any(), Mockito.anyString())).thenReturn(user);
		assertEquals("{\"message\": \"user successfully updated\"}", userRepo.updateUser(
				"{\"userEmail\":\"N.Cravensworth@gmail.com\",\"userName\":\"Nadja Cravensworth\",\"userPassword\":\"Password\",\"activityList\":[]}",
				"N.Cravensworth@gmail.com"));
	}
}