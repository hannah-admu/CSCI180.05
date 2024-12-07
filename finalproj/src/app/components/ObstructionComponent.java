package app.components;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Obstruction;
import app.entity.Report;
import app.entity.User;
import app.repository.ObstructionRepository;
import app.repository.ReportRepository;
import app.repository.UserRepository;

@Component
public class ObstructionComponent {

	@Autowired
    private ObstructionRepository obstructionRepository;
	
	@Autowired
    private ReportRepository reportRepository;

    @Autowired
    private LocationComponent locationComponent;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NotificationComponent notificationComponent;
    
    public void reportObstruction(String locationName, String specificLocation, String description, Double idNumber, String reportType) throws IOException {
        Long locationId = locationComponent.getLocationIdByName(locationName);

        Obstruction obstruction = new Obstruction();
        obstruction.setLocationId(locationId);
        obstruction.setLocationName(locationName);
        obstruction.setSpecificLocation(specificLocation);
        obstruction.setDescription(description);
        obstruction.setResolved(false);
        obstructionRepository.save(obstruction);

        // Log a report for the obstruction
        logReport(idNumber, obstruction.getId(), locationName, specificLocation, reportType, description);
    }
    
    // Method to make a report from the obstruction 
    private void logReport(Double idNumber, Long obstructionId, String locationName, String specificLocation, String reportType, String description) throws IOException {
        User user = userRepository.findByIdNumber(idNumber);
        Report report = new Report();
        report.setUserId(user.getId());
        report.setUsername(user.getUsername());
        report.setLocationId(obstructionId); //link to obstruction
        report.setLocationName(locationName);
        report.setSpecificLocation(specificLocation); //use specificLocation from reportObstruction 
        report.setDescription(description);
        report.setReportType(reportType);
        reportRepository.save(report);
        
        notificationComponent.notifyByObstacleLocation(obstructionId);
    }

    
    public List<Obstruction> getActiveObstructions(String locationName) {
    	 Long locationId = locationComponent.getLocationIdByName(locationName); 
         return obstructionRepository.findByLocationId(locationId);
    }
    
    // FOR CHECKING: Marks an Obstruction as resolved; returns a String comment containing details about the resolution.
    public String resolveObstruction(Long obstructionId, String resolutionComment) {
    	Optional<Obstruction> obstruction = obstructionRepository.findById(obstructionId);
    	
    	// Check if obstruction is null; if present, set its resolved status to true
    	if (obstruction.isPresent()) {
    		Obstruction obstructionToResolve = obstruction.get();
    		obstructionToResolve.setResolved(true);
    	} else {
    		throw new NoSuchElementException();
    	}
    	
    	// Return the resolutionComment as a string
        return "Obstruction resolved with comment: " + resolutionComment;
    }
    
    public void deleteObstruction(Long obstructionId) {
        if (!obstructionRepository.existsById(obstructionId)) {
            throw new EntityNotFoundException("Obstruction not found with ID: " + obstructionId);
        }
        obstructionRepository.deleteById(obstructionId);
    }
	
}
