package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull(message = "userId cannot be null")
    @Column
    private Long userId;

    @NotNull(message = "username cannot be null")
    @Column
    private String username;

    @NotNull(message = "reviewTitle cannot be null")
    @Size(max = 50, message = "max 50 characters")
    @Column
    private String reviewTitle;

    @NotNull(message = "reviewBody cannot be null")
    @Size(max = 250, message = "max 250 characters")
    @Column
    private String reviewBody;

    @NotNull(message = "locationId cannot be null")
    @Column
    private Long locationId;

    @NotNull(message = "locationName cannot be null")
    @Column
    private String locationName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
