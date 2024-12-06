package app.components;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Review;
import app.entity.User;
import app.repository.ReviewRepository;
import app.repository.UserRepository;

@Component
public class ReviewComponent {

	@Autowired
    private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private LocationComponent locationComponent;

    //WORKS - makes a new review based on the idNumber, username, locationName etc
    public void createReview(Double idNumber, String username, String locationName, String reviewTitle, String reviewBody) {
        
    	//check if user exists
        User user = userRepository.findByIdNumber(idNumber);
        if (user == null) {
            throw new EntityNotFoundException("User with ID number " + idNumber + " not found.");
        }

        //check if location exists
        Long locationId = locationComponent.getLocationIdByName(locationName);
        if (locationId == null) {
            throw new EntityNotFoundException("Location " + locationName + " not found.");
        }

        Review review = new Review();
        review.setUserId(user.getId());
        review.setUsername(username);
        review.setLocationId(locationId);
        review.setLocationName(locationName);
        review.setReviewTitle(reviewTitle);
        review.setReviewBody(reviewBody);
        reviewRepository.save(review);
    }

    
    //WORKS - returns all the reviews of that location in a JSON format based on locationName
    //      - if there are no reviews for that location, it returns []
    public List<Review> getLocationReviews(String locationName) {
        return reviewRepository.findByLocationNameContaining(locationName);
    }

    //WORKS - deletes a review based on review Id 
    //      - will only successfuly delete if the idNumber of the person who wrote 
    //      - the review belongs to the inputted idNumber of the person trying to delete the review
    public void deleteReview(Long reviewId, Double idNumber) {
        //check if user exists
        User user = userRepository.findByIdNumber(idNumber);
        if (user == null) {
            throw new EntityNotFoundException("User with ID number " + idNumber + " not found.");
        }

        //check if review exists
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> 
            new EntityNotFoundException("Review with ID " + reviewId + " not found."));
        
        //check if review belongs to the id number inputed. if does not belong, cannot delete
        if (!review.getUserId().equals(user.getId())) {
            throw new IllegalArgumentException("Review does not belong to the user with ID number " + idNumber);
        }

        reviewRepository.delete(review);
    }

    //WORKS - edits a review based on the given reviewId, newTitle and newBody
    //      - will only successfuly edit if the idNumber of the person who wrote 
    //      - the review belongs to the inputted idNumber of the person trying to edit the review
    public void editReview(Long reviewId, Double idNumber, String newTitle, String newBody) {
        //check if user exists
        User user = userRepository.findByIdNumber(idNumber);
        if (user == null) {
            throw new EntityNotFoundException("User with ID number " + idNumber + " not found.");
        }

        //check if review exists 
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> 
            new EntityNotFoundException("Review with ID " + reviewId + " not found."));
        
      //check if review belongs to the id number inputed. if does not belong, cannot edit
        if (!review.getUserId().equals(user.getId())) {
            throw new IllegalArgumentException("Review does not belong to the user with ID number " + idNumber);
        }
        
        review.setReviewTitle(newTitle);
        review.setReviewBody(newBody);
        reviewRepository.save(review);
    }

}
