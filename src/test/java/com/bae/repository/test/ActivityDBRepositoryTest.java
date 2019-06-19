package com.bae.repository.test;

import static org.junit.Assert.assertEquals;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Activity;
import com.bae.persistence.domain.Hiking;
import com.bae.persistence.domain.User;
import com.bae.persistence.repository.ActivityDBRepository;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ActivityDBRepositoryTest {

	@InjectMocks
	private ActivityDBRepository repo;
	
	@Mock
	private User userDetails;
	
	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_ACTIVITY = "{\"officialRouteName\":\"Wittenberg\",\"location\":\"Saxony-Anhalt\",\"lengthMiles\":\"343\",\"description\":\"lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In mi pede, nonummy ut, molestie in, tempus\",\"lifelogDirectory\":\"cursus purus. Nullam\",\"startDate\":\"\\\"2019-06-12\\\"\",\"endDate\":\"\\\"2019-06-22\\\"\"}";
	private static final String MOCK_EMAIL = "N.Cravensworth@gmail.com";

	@Before
	public void start() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	} 

	@Test
	public void addActivity() {
		User user = new User("N.Cravensworth@gmail.com","Nadja Cravensworth", "Password");
		Activity anActivity = new Hiking();
		Mockito.when(manager.find(Mockito.any(), Mockito.anyString())).thenReturn(user);
//		Mockito.when(userDetails.getActivityList().add(anActivity)).thenReturn(null);
		String reply = repo.createActivity(MOCK_EMAIL, MOCK_ACTIVITY);
		System.out.println(reply);
		assertEquals("{\"message\": \"activity successfully added\"}", reply);
	}

	@Test
	public void getAnActivity() {
		User user = new User("N.Cravensworth@gmail.com","Nadja Cravensworth", "Password");
		Mockito.when(manager.find(Mockito.any(), Mockito.anyString())).thenReturn(user);
		Activity anActivity = new Hiking();
		Mockito.when(userDetails.getActivityList().get(0)).thenReturn(anActivity);
		assertEquals("", repo.getAnActivity("N.Cravensworth@gmail.com", 0));

	}
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
