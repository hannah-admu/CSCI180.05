package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Review;
import app.repository.ReviewRepository;

@Component
public class ReviewComponent {

	@Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private LocationComponent locationComponent;

    //TO-DO
    public void createReview(Long userId, String username, String locationName, String reviewTitle, String reviewBody) {
       
    }

    
    public List<Review> getLocationReviews(String locationName) {
        return reviewRepository.findByLocationNameContaining(locationName);
    }

    //TO-DO
    public void deleteReview(Long reviewId, Long userId) {

    }

    
    //TO-DO
    public void editReview(Long reviewId, Long userId, String newTitle, String newBody) {
       
    }

}
