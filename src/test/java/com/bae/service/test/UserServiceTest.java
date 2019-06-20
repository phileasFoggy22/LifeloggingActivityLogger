package com.bae.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.UserServiceImp;
import com.bae.persistence.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	private static final String MOCK_VALUE3 = "test_value_3";
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private UserServiceImp service;

	@Mock
	private UserRepository userRepo;

	@Before
	public void setup() {
		service.setRepository(userRepo);
	}

	@Test
	public void testFetchAllUsers() {
		Mockito.when(userRepo.getAllUsers()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.getAllUsers());
	}

	@Test
	public void testCreateUser() {
		Mockito.when(userRepo.createUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.createUser(MOCK_VALUE2));
		Mockito.verify(userRepo).createUser(MOCK_VALUE2);
	}

	@Test
	public void testRemoveUser() {
		Mockito.when(userRepo.deleteUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.deleteUser(MOCK_VALUE2));
		Mockito.verify(userRepo).deleteUser(MOCK_VALUE2);
	}

	@Test
	public void testGetUser() {
		Mockito.when(userRepo.getUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.getUser(MOCK_VALUE2));
	}

	@Test
	public void testUpdateUser() {
		Mockito.when(userRepo.updateUser(MOCK_VALUE3, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.updateUser(MOCK_VALUE2, MOCK_VALUE3));
		Mockito.verify(userRepo).updateUser(MOCK_VALUE3, MOCK_VALUE2);
	}
}