package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.ReviewComponent;
import app.entity.Review;

@Component
@Path("/review")
public class ReviewController {

	@Autowired
    private ReviewComponent reviewComponent;

    //http://127.0.0.1:9999/review/submit
    @POST
    @Path("/submit")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String submitReview(@FormParam("idNumber") Double idNumber,
                               @FormParam("username") String username,
                               @FormParam("locationName") String locationName,
                               @FormParam("reviewTitle") String reviewTitle,
                               @FormParam("reviewBody") String reviewBody) {
        reviewComponent.createReview(idNumber, username, locationName, reviewTitle, reviewBody);
        return "Review submitted";
    }

    //http://127.0.0.1:9999/review/location
    @GET
    @Path("/location")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> getReviewsByLocation(@QueryParam("locationName") String locationName) {
        return reviewComponent.getLocationReviews(locationName);
    }

    //http://127.0.0.1:9999/review/edit
    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String editReview(@FormParam("reviewId") Long reviewId,
				             @FormParam("idNumber") Double idNumber,
				             @FormParam("newTitle") String newTitle,
				             @FormParam("newBody") String newBody) {
		reviewComponent.editReview(reviewId, idNumber, newTitle, newBody);
		return "Review edited";
    }
    
    //http://127.0.0.1:9999/review/delete
    @DELETE
    @Path("/delete")
    public String deleteReview(@QueryParam("reviewId") Long reviewId,
                               @QueryParam("idNumber") Double idNumber) {
        if (idNumber == null) {
            return "Error: idNumber is missing.";
        }
        if (reviewId == null) {
            return "Error: reviewId is missing.";
        }
        reviewComponent.deleteReview(reviewId, idNumber);
        return "Review deleted";
    }
	
}
