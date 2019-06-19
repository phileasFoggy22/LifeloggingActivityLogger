package com.bae.repository.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import com.bae.persistence.repository.ActivityDBRepository;
import com.bae.persistence.repository.UserDBRepository;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ActivityDBRepositoryTest {

	@InjectMocks
	private ActivityDBRepository repo;
	
	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_ACTIVITY = "{\"userEmail\":\"L.Cravensworth@gmail.com\",\"userName\":\"Laszlo Cravensworth\",\"password\":\"password\"}";
	private static final String MOCK_EMAIL = "L.Cravensworth@gmail.com";

	@Before
	public void start() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	} 

//	@Test
//	public void addActivity() {
////		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
////		String reply = repo.createActivity(MOCK_EMAIL, activityLog);
////		assertEquals("{\"message\": \"activity successfully added\"}", reply);
//	}
//
//	@Test
//	public void getUser() {
//			
//		User user = new User("N.Cravensworth@gmail.com","Nadja Cravensworth", "Password");
//		Mockito.when(manager.find(Mockito.any(), Mockito.anyString())).thenReturn(user);
//		assertEquals("{\"userEmail\":\"N.Cravensworth@gmail.com\",\"userName\":\"Nadja Cravensworth\",\"userPassword\":\"Password\",\"activityList\":[]}", repo.getUser("N.Cravensworth@gmail.com"));
//
//	}
//
//	@Test
//	public void updateUser() {
//		User user = new User("N.Cravensworth@gmail.com","Nadja Cravensworth", "Password");
//		Mockito.when(manager.find(Mockito.any(), Mockito.anyString())).thenReturn(user);
//		assertEquals("{\"message\": \"user successfully updated\"}", repo.updateUser("{\"userEmail\":\"N.Cravensworth@gmail.com\",\"userName\":\"Nadja Cravensworth\",\"userPassword\":\"Password\",\"activityList\":[]}", "N.Cravensworth@gmail.com"));
//	}
//
//	@Test
//	public void deleteUser() {
//		String reply = repo.deleteUser("N.Cravensworth@gmail.com");
//		Assert.assertEquals(reply, "{\"message\": \"User sucessfully removed\"}");
//	}

}
