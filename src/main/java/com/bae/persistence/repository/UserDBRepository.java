package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional(SUPPORTS)
@Default
public class UserDBRepository implements ActivityRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Override
	public String createActivity(String activityLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAnActivity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllActivities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllActivitiesByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateActivity(String activityLog, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteActivity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
