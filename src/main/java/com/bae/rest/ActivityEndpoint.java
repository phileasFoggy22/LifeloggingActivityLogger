package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.business.service.ActivityService;

@Path("/activities")
public class ActivityEndpoint {
	
	@Inject
	private ActivityService service;
	
	// Create
	@Path("/createActivity")
	@POST
	@Produces({"application/json"})
	public String createActivity(String userEmail,String activityLog) {
		return service.createActivity(userEmail,activityLog);
	}
	
	// Read
	@Path("/getAnActivity/{id}")
	@GET
	@Produces({"application/json"})
	public String getAnActivity(String userEmail,Long id) {
		return service.getAnActivity(userEmail,id);
	}
	
	//Read
	@Path("/getAllActivities")
	@GET
	@Produces({"application/json"})
	public String getAllActivities(String userEmail) {
		return service.getAllActivities(userEmail);
	}
	
	//Read
	@Path("/getActivitiesByCategory")
	@GET
	@Produces({"application/json"})
	public String getAllActivitiesByCategory(String userEmail,String category) {
		return service.getAllActivitiesByCategory(userEmail,category);
	}
	
	// Update
	@Path("/updateActivity/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateActivity(String userEmail,String activityLog, Long id) {
		return service.updateActivity(userEmail,activityLog, id);
	}
		
	// Delete
	@Path("/deleteActivity/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteActivity(String userEmail,Long id) {
		return service.deleteActivity(userEmail,id);
	}
}



