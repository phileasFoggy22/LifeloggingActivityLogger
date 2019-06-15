package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Activity;
import com.bae.persistence.domain.User;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ActivityDBRepository implements ActivityRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	private User userDetails;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createActivity(String userEmail, String activityLog) {
		userDetails = manager.find(User.class, userEmail);
		Activity anActivity = util.getObjectForJSON(activityLog, Activity.class);
		userDetails.getActivityList().add(anActivity);
		return "{\"message\": \"activity sucessfully added\"}";
	}

	@Override
	public String getAnActivity(String userEmail, int id) {
		userDetails = manager.find(User.class, userEmail);
		return util.getJSONForObject(userDetails.getActivityList().get(id));
	}

	@Override
	public String getAllActivities(String userEmail) {
		userDetails = manager.find(User.class, userEmail);
		return null;
	}

	@Override
	public String getAllActivitiesByCategory(String userEmail, String category) {
		userDetails = manager.find(User.class, userEmail);
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String updateActivity(String userEmail, String activityLog, Long id) {
		userDetails = manager.find(User.class, userEmail);
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteActivity(String userEmail, Long id) {
		userDetails = manager.find(User.class, userEmail);
		return null;
	}
}
