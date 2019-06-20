package com.bae.rest.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.ActivityService;
import com.bae.rest.ActivityEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class ActivityEndPointTest {

	private static final int MOCK_VALUE4 = 1;
	private static final String MOCK_VALUE3 = "test_value_3";
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private ActivityEndpoint endpoint;

	@Mock
	private ActivityService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testFetchAllActivities() {
		Mockito.when(service.getAllActivities(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, endpoint.getAllActivities(MOCK_VALUE));
	}

	@Test
	public void testFetchAllActivitiesByCategory() {
		Mockito.when(service.getAllActivitiesByCategory(MOCK_VALUE, MOCK_VALUE2)).thenReturn(MOCK_VALUE3);
		Assert.assertEquals(MOCK_VALUE3, endpoint.getAllActivitiesByCategory(MOCK_VALUE, MOCK_VALUE2));
	}

	@Test
	public void testFetchAnActivity() {
		Mockito.when(service.getAnActivity(MOCK_VALUE, MOCK_VALUE4)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, endpoint.getAnActivity(MOCK_VALUE, MOCK_VALUE4));
	}

	@Test
	public void testCreateActivity() {
		Mockito.when(service.createActivity(MOCK_VALUE, MOCK_VALUE2)).thenReturn(MOCK_VALUE3);
		Assert.assertEquals(MOCK_VALUE3, endpoint.createActivity(MOCK_VALUE, MOCK_VALUE2));
		Mockito.verify(service).createActivity(MOCK_VALUE, MOCK_VALUE2);
	}

	@Test
	public void testRemoveActivity() {
		Mockito.when(service.deleteActivity(MOCK_VALUE, MOCK_VALUE4)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, endpoint.deleteActivity(MOCK_VALUE, MOCK_VALUE4));
		Mockito.verify(service).deleteActivity(MOCK_VALUE, MOCK_VALUE4);
	}

	@Test
	public void testUpdateActivity() {
		Mockito.when(service.updateActivity(MOCK_VALUE, MOCK_VALUE3, MOCK_VALUE4)).thenReturn(MOCK_VALUE2);
		Assert.assertEquals(MOCK_VALUE2, endpoint.updateActivity(MOCK_VALUE, MOCK_VALUE3, MOCK_VALUE4));
		Mockito.verify(service).updateActivity(MOCK_VALUE, MOCK_VALUE3, MOCK_VALUE4);
	}
}