package app.rest.controllers;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.LocationComponent;
import app.entity.Location;

@Component
@Path("/location")
public class LocationController {
	
	@Autowired
	LocationComponent locationComponent;
	
    //http://127.0.0.1:9999/location/features
    @GET
    @Path("/features")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Location getAccessibilityFeatures(@FormParam("locationName") String locationName) {
        return locationComponent.getLocationFeatures(locationName);
    }

    //http://127.0.0.1:9999/location/withRamps
    @POST
    @Path("/withRamps")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> getLocationsWithRamps() {
        return locationComponent.getLocationsWithRamps();
    }

    //http://127.0.0.1:9999/location/withElevators
    @POST
    @Path("/withElevators")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> getLocationsWithElevators() {
        return locationComponent.getLocationsWithElevators();
    } 
    
    //http://127.0.0.1:9999/location/obstructions
    @POST
    @Path("/obstructions")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getObstructionsByLocation(@FormParam("locationName") String locationName) {
        return null; 
    }
    
}


