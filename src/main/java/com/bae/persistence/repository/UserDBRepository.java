package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.User;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserDBRepository implements UserRepository {
	@PersistenceContext(name = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(TxType.REQUIRED)
	public String createUser(String userJSON) {
		// User newUser = util.getObjectForJSON(userJSON, User.class);
		// System.out.println("error: " + newUser);
		// manager.persist(newUser);
		return "{\"message\": \"user successfully added\"}";
	}

	@Override
	public String getUser(String userEmail) {
		User aUser = manager.find(User.class, userEmail);
		return util.getJSONForObject(aUser);
	}

	@Override
	public String getAllUsers() {
		TypedQuery<User> query = manager.createQuery("SELECT a FROM Users a", User.class);
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String updateUser(String userJSON, String userEmail) {
		User theUser = util.getObjectForJSON(userJSON, User.class);
		User updateThisUser = manager.find(User.class, userEmail);
		updateThisUser.setUserEmail(theUser.getUserEmail());
		updateThisUser.setUserName(theUser.getUserName());
		updateThisUser.setUserPassword(theUser.getUserPassword());
		manager.persist(updateThisUser);
		return "{\"message\": \"user successfully updated\"}";

	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String deleteUser(String userEmail) {
		User aUser = manager.find(User.class, userEmail);
		manager.remove(aUser);
		return "{\"message\": \"User sucessfully removed\"}";
	}

}
