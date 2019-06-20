package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ActivityRepository;

public class ActivityServiceImp implements ActivityService {

	@Inject
	private ActivityRepository actRepo;

	@Override
	public String createActivity(String userEmail, String activityLog) {
		return actRepo.createActivity(userEmail, activityLog);

	}

	@Override
	public String getAnActivity(String userEmail, int id) {

		return actRepo.getAnActivity(userEmail, id);

	}

	@Override
	public String getAllActivities(String userEmail) {
		return actRepo.getAllActivities(userEmail);
	}

	@Override
	public String getAllActivitiesByCategory(String userEmail, String category) {

		return actRepo.getAllActivitiesByCategory(userEmail, category);
	}

	@Override
	public String updateActivity(String userEmail, String activityLog, int id) {
		return actRepo.updateActivity(userEmail, activityLog, id);
	}

	@Override
	public String deleteActivity(String userEmail, int id) {
		return actRepo.deleteActivity(userEmail, id);

	}

	public void setRepository(ActivityRepository actRepo) {
		this.actRepo = actRepo;
	}

}
