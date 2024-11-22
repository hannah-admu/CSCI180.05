package app.rest.controllers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.ReportComponent;
import app.entity.Report;

@Component
@Path("/report")
public class ReportController {
	
	@Autowired
    private ReportComponent reportComponent;

    //get all reports
    //http://127.0.0.1:9999/report/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getAllReports() {
        return reportComponent.getAllReports();
    }

    //get reports by user
    //http://127.0.0.1:9999/report/user
    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getReportsByUser(@QueryParam("idNumber") Double idNumber) {
        return reportComponent.getReportsByUser(idNumber);
    }

    //get reports by location name
    //http://127.0.0.1:9999/report/locationName
    @GET
    @Path("/locationName")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getReportsByLocationName(@QueryParam("keyword") String locationName) {
        return reportComponent.getReportsByLocationName(locationName);
    }

    //get reports by description containing something
    //http://127.0.0.1:9999/report/description
    @GET
    @Path("/description")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getReportsByDescription(@QueryParam("keyword") String description) {
        return reportComponent.getReportsByDescription(description);
    }
    
    //delete a report based on report Id 
  //http://127.0.0.1:9999/report/delete
    @DELETE
    @Path("/delete")
    public String deleteReport(@QueryParam("reportId") Long reportId) {
        reportComponent.deleteReport(reportId);
        return "Report deleted successfully.";
    }
	
}
