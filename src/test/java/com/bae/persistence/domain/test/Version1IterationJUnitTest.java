package com.bae.persistence.domain.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.UserService;
import com.bae.rest.UserEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class Version1IterationJUnitTest {

	private static final String MOCK_VALUE3 = "test_value_3";
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private UserEndpoint endpoint;

	@Mock
	private UserService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testFetchAllUsers() {
		Mockito.when(service.getAllUsers()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllUsers());
	}

	@Test
	public void testCreateUser() {
		Mockito.when(service.createUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createUser(MOCK_VALUE2));
		Mockito.verify(service).createUser(MOCK_VALUE2);
	}

	@Test
	public void testRemoveUser() {
		Mockito.when(service.deleteUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteUser(MOCK_VALUE2));
		Mockito.verify(service).deleteUser(MOCK_VALUE2);
	}

	@Test
	public void testGetUser() {
		Mockito.when(service.getUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getUser(MOCK_VALUE2));
		Mockito.verify(service).getUser(MOCK_VALUE2);
	}

	@Test
	public void testUpdateUser() {
		Mockito.when(service.updateUser(MOCK_VALUE2, MOCK_VALUE3)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.updateUser(MOCK_VALUE2, MOCK_VALUE3));
		Mockito.verify(service).updateUser(MOCK_VALUE2, MOCK_VALUE3);
	}
}