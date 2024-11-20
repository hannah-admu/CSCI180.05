package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@NotNull (message = "name cannot be null")
	@Column
	private String name;
	
	@NotNull (message = "latitude cannot be null")
	@Min(value = -90, message = "must be between -90 and 90")
	@Max(value = 90, message = "must be between -90 and 90")
	@Column
	private Double latitude; 
	
	@NotNull (message = "longitude cannot be null")
	@Min(value = -180, message = "must be between -180 and 180")
	@Max(value = 180, message = "must be between -180 and 180")
	@Column
	private Double longitude; 
	
	@NotNull (message = "hasRamp cannot be null")
	@Column
	private Boolean hasRamp;
	
	@NotNull (message = "hasElevator cannot be null")
	@Column
	private Boolean hasElevator;
	
	@Size(max = 255, message = "max 255 characters")
	@Column
	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Boolean getHasRamp() {
		return hasRamp;
	}

	public void setHasRamp(Boolean hasRamp) {
		this.hasRamp = hasRamp;
	}

	public Boolean getHasElevator() {
		return hasElevator;
	}

	public void setHasElevator(Boolean hasElevator) {
		this.hasElevator = hasElevator;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	} 
	
}
