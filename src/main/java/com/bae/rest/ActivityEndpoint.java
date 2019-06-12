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
	public String createActivity(String activityLog) {
		return service.createActivity(activityLog);
	}
	
	// Read
	@Path("/getAnActivity/{id}")
	@GET
	@Produces({"application/json"})
	public String getAnActivity(Long id) {
		return service.getAnActivity(id);
	}
	
	//Read
	@Path("/getAllActivities")
	@GET
	@Produces({"application/json"})
	public String getAllActivities() {
		return service.getAllActivities();
	}
	
	//Read
	@Path("/getActivitiesByCategory")
	@GET
	@Produces({"application/json"})
	public String getAllActivitiesByCategory(String category) {
		return service.getAllActivitiesByCategory(category);
	}
	
	// Update
	@Path("/updateActivity/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateActivity(String activityLog, Long id) {
		return service.updateActivity(activityLog, id);
	}
		
	// Delete
	@Path("/deleteActivity/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteActivity(Long id) {
		return service.deleteActivity(id);
	}
}



