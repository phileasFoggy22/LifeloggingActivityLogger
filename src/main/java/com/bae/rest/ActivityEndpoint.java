package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.ActivityService;

@Path("/activities")
public class ActivityEndpoint {

	@Inject
	private ActivityService service;

	// Create
	@Path("/createActivity/{email}")
	@POST
	@Produces({ "application/json" })
	public String createActivity(@PathParam("email") String userEmail, String activityLog) {
		return service.createActivity(userEmail, activityLog);
	}

	// Read
	@Path("/getAnActivity/{email}/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnActivity(@PathParam("email") String userEmail, @PathParam("id") int id) {
		return service.getAnActivity(userEmail, id);
	}

	// Read
	@Path("/getAllActivities/{email}")
	@GET
	@Produces({ "application/json" })
	public String getAllActivities(@PathParam("email") String userEmail) {
		return service.getAllActivities(userEmail);
	}

	// Read
	@Path("/getActivitiesByCategory/{email}/{category}")
	@GET
	@Produces({ "application/json" })
	public String getAllActivitiesByCategory(@PathParam("email") String userEmail,
			@PathParam("category") String category) {
		return service.getAllActivitiesByCategory(userEmail, category);
	}

	// Update
	@Path("/updateActivity/{email}/{id}")
	@PUT
	@Produces({ "application/json" })

	public String updateActivity(@PathParam("email") String userEmail, String activityLog, @PathParam("id") int id) {

		return service.updateActivity(userEmail, activityLog, id);
	}

	// Delete
	@Path("/removeActivity/{email}/{id}")
	@DELETE
	@Produces({ "application/json" })

	public String deleteActivity(@PathParam("email") String userEmail, @PathParam("id") int id) {

		return service.deleteActivity(userEmail, id);
	}
}
