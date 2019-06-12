package com.bae.business.service;

public interface ActivityService {
	
	// Create
	String createActivity(String userEmail,String activityLog);

	// Read
	String getAnActivity(String userEmail,Long id);

	String getAllActivities(String userEmail);

	String getAllActivitiesByCategory(String userEmail,String category);

	// Update
	String updateActivity(String userEmail,String activityLog, Long id);

	// Delete
	String deleteActivity(String userEmail,Long id);
}
