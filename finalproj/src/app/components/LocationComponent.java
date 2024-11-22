package app.components;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Location;
import app.repository.LocationRepository;
import app.repository.ObstructionRepository;

@Component
public class LocationComponent {
	
	@Autowired
	private LocationRepository locationRepository;
	
    @Autowired
    private ObstructionRepository obstructionRepository;
	
	///TO-DO: add more locations
	@PostConstruct
	public void initializeLocations() {
		
		if(locationRepository.count() == 0) {
			
			Location faura = new Location();
			faura.setName("Faura");
			faura.setLatitude(14.639793431909977);
	        faura.setLongitude(121.0768671219206);
	        faura.setHasRamp(true);
	        faura.setHasElevator(false);
	        faura.setNotes("Smells like cat shit");
	        locationRepository.save(faura);
	        
	        Location secA = new Location();
            secA.setName("SEC A");
            secA.setLatitude(14.638203114345151);
			secA.setLongitude(121.07748090951925);
            secA.setHasRamp(true);
            secA.setHasElevator(true);
            secA.setNotes("math building");
            locationRepository.save(secA);
		}
		
	}
	
    public void createLocation(String name, Double latitude, Double longitude, Boolean hasRamp, Boolean hasElevator, String notes) {
        Location location = new Location();
        location.setName(name);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setHasRamp(hasRamp);
        location.setHasElevator(hasElevator);
        location.setNotes(notes);
        locationRepository.save(location);
    }

    public void deleteLocation(String locationName) {
        Location location = locationRepository.findByName(locationName);
        if (location != null) {
            locationRepository.delete(location);
        } else {
            throw new EntityNotFoundException("Location not found: " + locationName);
        }
    }
	
	//TO-DO: need to return location features
	public Location getLocationFeatures(String locationName) {
		
		Location location = locationRepository.findByName(locationName);
		if (location == null) {
            throw new EntityNotFoundException("Location not found: " + locationName);
        }
		return location;
		
	}
	
	public Long getLocationIdByName(String locationName) {
        Location location = locationRepository.findByName(locationName);
        if (location == null) {
            throw new EntityNotFoundException("Location not found: " + locationName);
        }
        return location.getId();
    }
	
	public List<Location> getLocationsWithRamps() {
        return locationRepository.findByHasRamp(true);
    }

    public List<Location> getLocationsWithElevators() {
        return locationRepository.findByHasElevator(true);
    }

    //TO-DO
	public Map<String, Object> getObstructionsByLocation(String locationName) {
		return null;
	}

}
