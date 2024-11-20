package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.UserComponent;

@Component
@Path("/user")
public class UserController {
	
	@Autowired
    private UserComponent userComponent;

	// Example: http://127.0.0.1:9999/user/create
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(@FormParam("username") String username,
	                         @FormParam("phoneNumber") String phoneNumber,
	                         @FormParam("idNumber") Double idNumber) {
		return "User added";
	}

	//http://127.0.0.1:9999/user/updatePhone
	@POST
	@Path("/updatePhone")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updatePhoneNumber(@FormParam("idNumber") Double idNumber,
	                                @FormParam("phoneNumber") String phoneNumber) {
		userComponent.updatePhoneNumber(idNumber, phoneNumber);
		return "Phone number updated";
	}

	//http://127.0.0.1:9999/user/preferences/set
	@POST
	@Path("/preferences/set")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String setNotificationPreferences(@FormParam("idNumber") Double idNumber,
											 @FormParam("locationNames") List<String> locationNames) {
		userComponent.setNotificationPreferences(idNumber, locationNames);
		return "Preferences set";
	}

	//http://127.0.0.1:9999/user/preferences/get
	@POST
	@Path("/preferences/get")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getNotificationPreferences(@FormParam("idNumber") Double idNumber) {
		return userComponent.getNotificationPreferences(idNumber);
	}

}
