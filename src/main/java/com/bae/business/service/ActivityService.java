package com.bae.business.service;

public interface ActivityService {
	
	// Create
	String createActivity(String activityLog);

	// Read
	String getAnActivity(Long id);

	String getAllActivities();

	String getAllActivitiesByCategory(String category);

	// Update
	String updateActivity(String activityLog, Long id);

	// Delete
	String deleteActivity(Long id);
}
