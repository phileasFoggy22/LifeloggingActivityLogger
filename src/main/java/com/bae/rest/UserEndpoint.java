package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.UserServiceImp;

@Path("/users")
public class UserEndpoint {

	@Inject
	private UserServiceImp service;

	// Create
	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String createUser(String userJSON) {
		return service.createUser(userJSON);
	}

	// Read
	@Path("/fetchUser/{email}")
	@GET
	@Produces({ "application/json" })
	public String getUser(@PathParam("email") String userEmail) {
		return service.getUser(userEmail);
	}

	// Read
	@Path("/fetchAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return service.getAllUsers();
	}

	// // Update
	@Path("/updateUser/{email}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("email") String userEmail, String userJSON) {
		return service.updateUser(userEmail, userJSON);
	}

	//
	// // Delete
	@Path("/removeUser/{email}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("email") String userEmail) {
		return service.deleteUser(userEmail);
	}
}
