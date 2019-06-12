package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ActivityRepository;


public class ActivityServiceImp implements ActivityService{
	
	@Inject
	private ActivityRepository repo;
	@Override
	public String createActivity(String activityLog) {
		
		return repo.createActivity(activityLog);
	}

	@Override
	public String getAnActivity(Long id) {
		return repo.getAnActivity(id);
	}

	@Override
	public String getAllActivities() {
		return repo.getAllActivities();
	}

	@Override
	public String getAllActivitiesByCategory(String category) {
		return repo.getAllActivitiesByCategory(category);
	}

	@Override
	public String updateActivity(String activityLog, Long id) {
		return repo.updateActivity(activityLog, id);
	}

	@Override
	public String deleteActivity(Long id) {
		return repo.deleteActivity(id);
	}

}
