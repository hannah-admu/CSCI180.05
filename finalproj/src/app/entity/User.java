package app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull(message = "username cannot be null")
    @Column
    private String username;

    @Column
    private Boolean admin = false; //default set it to false

    @NotNull(message = "phone number cannot be null")
    @Column
    private String phoneNumber;

    @NotNull(message = "idNumber cannot be null")
    @Column
    private Double idNumber;

    @ElementCollection
    @Column
    private List<Long> locationNotifications;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Double idNumber) {
		this.idNumber = idNumber;
	}

	public List<Long> getLocationNotifications() {
		return locationNotifications;
	}

	public void setLocationNotifications(List<Long> locationNotifications) {
		this.locationNotifications = locationNotifications;
	}
    
}
