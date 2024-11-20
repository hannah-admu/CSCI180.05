package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Report {
	
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

    @NotNull(message = "locationId cannot be null")
    @Column
    private Long locationId;

    @NotNull(message = "locationName cannot be null")
    @Column
    private String locationName;

    @NotNull(message = "specificLocation cannot be null")
    @Column
    private String specificLocation;

    @NotNull(message = "description cannot be null")
    @Size(max = 250, message = "max 250 characters")
    @Column
    private String description;
    
    @NotNull(message = "reportType cannot be null")
    @Column
    private String reportType;

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

	public String getSpecificLocation() {
		return specificLocation;
	}

	public void setSpecificLocation(String specificLocation) {
		this.specificLocation = specificLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

}
