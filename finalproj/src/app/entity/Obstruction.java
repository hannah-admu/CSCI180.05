package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Obstruction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id; 
	
	@NotNull (message = "locationId cannot be null")
	@Column
	private Long locationId; 
	
	@NotNull (message = "locationName cannot be null")
	@Column
	private String locationName; 
	
	@NotNull (message = "specificLocation cannot be null")
	@Column
	private String specificLocation; 
	
	@NotNull (message = "description cannot be null")
	@Size(max = 255, message = "max 255 characters")
	@Column
	private String description;
	
	@NotNull (message = "resolved cannot be null")
	@Column
	private Boolean resolved = false; //default set it to false  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getResolved() {
		return resolved;
	}

	public void setResolved(Boolean resolved) {
		this.resolved = resolved;
	}
	
	
}
