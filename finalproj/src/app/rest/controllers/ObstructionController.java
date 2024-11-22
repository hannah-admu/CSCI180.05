package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.ObstructionComponent;

@Component
@Path("/obstruction")
public class ObstructionController {
	
	@Autowired
    private ObstructionComponent obstructionComponent;

    //http://127.0.0.1:9999/obstruction/report
    @POST
    @Path("/report")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String reportObstruction(@FormParam("idNumber") Double idNumber,
						            @FormParam("locationName") String locationName,
						            @FormParam("specificLocation") String specificLocation,
						            @FormParam("description") String description,
						            @FormParam("reportType") String reportType) {
        obstructionComponent.reportObstruction(locationName, specificLocation, description, idNumber, reportType);
        return "Obstruction reported successfully.";
    }

    //http://127.0.0.1:9999/obstruction/resolve
    @POST
    @Path("/resolve")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String resolveObstruction(@FormParam("obstructionId") Long obstructionId,
                                     @FormParam("resolutionComment") String resolutionComment) {
        return obstructionComponent.resolveObstruction(obstructionId, resolutionComment);
    }
    
    //http://127.0.0.1:9999/obstruction/delete
    @DELETE
    @Path("/delete")
    public String deleteObstruction(@QueryParam("obstructionId") Long obstructionId) {
        obstructionComponent.deleteObstruction(obstructionId);
        return "Obstruction deleted successfully.";
    }

}
