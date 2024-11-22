package app.rest.controllers;

import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.LocationComponent;
import app.entity.Location;

@Component
@Path("/location")
public class LocationController {

    @Autowired
    private LocationComponent locationComponent;

    //http://127.0.0.1:9999/location/features
    @GET
    @Path("/features")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getAccessibilityFeatures(@QueryParam("locationName") String locationName) {
        return locationComponent.getLocationFeatures(locationName);
    }

    //http://127.0.0.1:9999/location/withRamps
    @GET
    @Path("/withRamps")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> getLocationsWithRamps() {
        return locationComponent.getLocationsWithRamps();
    }

    //http://127.0.0.1:9999/location/withElevators
    @GET
    @Path("/withElevators")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> getLocationsWithElevators() {
        return locationComponent.getLocationsWithElevators();
    }

    //http://127.0.0.1:9999/location/obstructions
    @GET
    @Path("/obstructions")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getObstructionsByLocation(@QueryParam("locationName") String locationName) {
        return locationComponent.getObstructionsByLocation(locationName);
    }

    //http://127.0.0.1:9999/location/create
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createLocation(
        @FormParam("name") String name,
        @FormParam("latitude") Double latitude,
        @FormParam("longitude") Double longitude,
        @FormParam("hasRamp") Boolean hasRamp,
        @FormParam("hasElevator") Boolean hasElevator,
        @FormParam("notes") String notes
    ) {
        locationComponent.createLocation(name, latitude, longitude, hasRamp, hasElevator, notes);
        return "Location created successfully.";
    }

    //http://127.0.0.1:9999/location/delete
    @DELETE
    @Path("/delete")
    public String deleteLocation(@QueryParam("locationName") String locationName) {
        locationComponent.deleteLocation(locationName);
        return "Location deleted successfully.";
    }
}
