package com.bae.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.ActivityServiceImp;
import com.bae.persistence.repository.ActivityRepository;

@RunWith(MockitoJUnitRunner.class)
public class ActivityServiceTest {

	private static final int MOCK_VALUE4 = 1;
	private static final String MOCK_VALUE3 = "test_value_3";
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private ActivityServiceImp service;

	@Mock
	private ActivityRepository repo;

	@Before
	public void setup() {
		service.setRepository(repo);
	}

	@Test
	public void testFetchAllActivities() {
		Mockito.when(repo.getAllActivities(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, service.getAllActivities(MOCK_VALUE));
	}

	@Test
	public void testFetchAllActivitiesByCategory() {
		Mockito.when(repo.getAllActivitiesByCategory(MOCK_VALUE, MOCK_VALUE2)).thenReturn(MOCK_VALUE3);
		Assert.assertEquals(MOCK_VALUE3, service.getAllActivitiesByCategory(MOCK_VALUE, MOCK_VALUE2));
	}

	@Test
	public void testFetchAnActivity() {
		Mockito.when(repo.getAnActivity(MOCK_VALUE, MOCK_VALUE4)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, service.getAnActivity(MOCK_VALUE, MOCK_VALUE4));
	}

	@Test
	public void testCreateActivity() {
		Mockito.when(repo.createActivity(MOCK_VALUE, MOCK_VALUE2)).thenReturn(MOCK_VALUE3);
		Assert.assertEquals(MOCK_VALUE3, service.createActivity(MOCK_VALUE, MOCK_VALUE2));
		Mockito.verify(repo).createActivity(MOCK_VALUE, MOCK_VALUE2);
	}

	@Test
	public void testRemoveActivity() {
		Mockito.when(repo.deleteActivity(MOCK_VALUE, MOCK_VALUE4)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, service.deleteActivity(MOCK_VALUE, MOCK_VALUE4));
		Mockito.verify(repo).deleteActivity(MOCK_VALUE, MOCK_VALUE4);
	}

	@Test
	public void testUpdateActivity() {
		Mockito.when(repo.updateActivity(MOCK_VALUE, MOCK_VALUE3, MOCK_VALUE4)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, service.updateActivity(MOCK_VALUE, MOCK_VALUE3, MOCK_VALUE4));
		Mockito.verify(repo).updateActivity(MOCK_VALUE, MOCK_VALUE3, MOCK_VALUE4);
	}
}