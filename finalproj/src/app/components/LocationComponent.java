package app.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Location;
import app.entity.Obstruction;
import app.repository.LocationRepository;
import app.repository.ObstructionRepository;

@Component
public class LocationComponent {
	
	@Autowired
	private LocationRepository locationRepository;
	
    @Autowired
    private ObstructionRepository obstructionRepository;
	
	// FOR CHECKING: 20 locations in total!
	@PostConstruct
	public void initializeLocations() {
		
		if(locationRepository.count() == 0) {
			
			Location faura = new Location();
			faura.setName("Faura Hall");
			faura.setLatitude(14.639793431909977);
	        faura.setLongitude(121.0768671219206);
	        faura.setHasRamp(true);
	        faura.setHasElevator(false);
	        faura.setNotes("Smells like cat shit!");
	        locationRepository.save(faura);
	        
	        Location secA = new Location();
            secA.setName("SEC A");
            secA.setLatitude(14.638203114345151);
			secA.setLongitude(121.07748090951925);
            secA.setHasRamp(true);
            secA.setHasElevator(true);
            secA.setNotes("math building");
            locationRepository.save(secA);
            
            Location secB = new Location();
            secB.setName("SEC B");
            secB.setLatitude(14.638097770140083);
            secB.setLongitude(121.07720658444957);
            secB.setHasRamp(true);
            secB.setHasElevator(false);
            secB.setNotes("Also known as the Science Education Complex B.");
            locationRepository.save(secB);
            
            Location secC = new Location();
            secC.setName("SEC C");
            secC.setLatitude(14.639664314393684);
            secC.setLongitude(121.0774208267799);
            secC.setHasRamp(false);
            secC.setHasElevator(true);
            secC.setNotes("Also known as sexy.");
            locationRepository.save(secC);
            
            Location newRizz = new Location();
            newRizz.setName("New Rizal Library");
            newRizz.setLatitude(14.640222798297907);
            newRizz.setLongitude(121.076099909928);
            newRizz.setHasRamp(false);
            newRizz.setHasElevator(true);
            newRizz.setNotes("Pepe Rizal's home.");
            locationRepository.save(newRizz);
            
            Location faber = new Location();
            faber.setName("Faber Hall");
            faber.setLatitude(14.641118676667764);
            faber.setLongitude(121.07785649728346);
            faber.setHasRamp(false);
            faber.setHasElevator(true);
            faber.setNotes("Home to the Ateneo's #1 restrooms.");
            locationRepository.save(faber);
            
            Location arete = new Location();
            arete.setName("Arete");
            arete.setLatitude(14.641118676667764);
            arete.setLongitude(121.07785649728346);
            arete.setHasRamp(true);
            arete.setHasElevator(true);
            arete.setNotes("Home to the Ateneo's #2 restrooms.");
            locationRepository.save(arete);
            
            Location ctc = new Location();
            ctc.setName("CTC");
            ctc.setLatitude(14.6384473139613);
            ctc.setLongitude(121.07659343506627);
            ctc.setHasRamp(false);
            ctc.setHasElevator(true);
            ctc.setNotes("CTC has 5 floors?!");
            locationRepository.save(ctc);
            
            Location jsec = new Location();
            jsec.setName("John Gokongwei Student Enterprise Centers");
            jsec.setLatitude(14.637810562716378);
            jsec.setLongitude(121.0763171632968);
            jsec.setHasRamp(false);
            jsec.setHasElevator(false);
            jsec.setNotes("Bring back JEFE!");
            locationRepository.save(jsec);
            
            Location xavier = new Location();
            xavier.setName("Xavier Hall");
            xavier.setLatitude(14.637810562716378);
            xavier.setLongitude(121.0763171632968);
            xavier.setHasRamp(true);
            xavier.setHasElevator(true);
            xavier.setNotes("I love Xavier cat.");
            locationRepository.save(xavier);
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
	
	// FOR CHECKING: Returns a String sentence stating a locatoin's available features
	public String getLocationFeatures(String locationName) {
		Location location = locationRepository.findByName(locationName);
		if (location == null) {
            throw new EntityNotFoundException("Location not found: " + locationName);
        }	
		String elevatorPresence = ((location.getHasElevator() == true) ? "has an elevator" : "does not have an elevator");
		String rampPresence = ((location.getHasRamp() == true) ? "has a ramp" : "does not have a ramp");		
		return locationName + " " + elevatorPresence + " and " + rampPresence + ".";
		
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

    // FOR CHECKING: Returns a map containing  key-value pairs where key is Location name and value is the Obstruction object.
	public Map<String, Object> getObstructionsByLocation(String locationName) {
		List<Obstruction> obstructions = obstructionRepository.findByLocationNameContaining(locationName);
		if (obstructions == null || obstructions.isEmpty()) {
			throw new EntityNotFoundException("No obstructions found in " + locationName);
		}
        Map<String, Object> locationObstructions = new HashMap<>(); 
		for (Obstruction obstruction : obstructions) {
			locationObstructions.put(obstruction.getLocationName(), obstruction);
		}
		return locationObstructions;
	}

}
