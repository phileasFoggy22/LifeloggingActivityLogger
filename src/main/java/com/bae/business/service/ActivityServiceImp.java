package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ActivityRepository;


public class ActivityServiceImp implements ActivityService{
	
	@Inject
	private ActivityRepository repo;
	@Override
	public String createActivity(String userEmail,String activityLog) {
		
		return repo.createActivity(userEmail, activityLog);
	}

	@Override
	public String getAnActivity(String userEmail,Long id) {
		return repo.getAnActivity(userEmail,id);
	}

	@Override
	public String getAllActivities(String userEmail) {
		return repo.getAllActivities(userEmail);
	}

	@Override
	public String getAllActivitiesByCategory(String userEmail,String category) {
		return repo.getAllActivitiesByCategory(userEmail,category);
	}

	@Override
	public String updateActivity(String userEmail,String activityLog, Long id) {
		return repo.updateActivity(userEmail, activityLog, id);
	}

	@Override
	public String deleteActivity(String userEmail,Long id) {
		return repo.deleteActivity(userEmail,id);
	}

}
