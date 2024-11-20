package app.components;

import java.util.List;

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
    
    public void reportObstruction(String locationName, String specificLocation, String description, Double idNumber, String reportType) {
        Long locationId = locationComponent.getLocationIdByName(locationName);

        Obstruction obstruction = new Obstruction();
        obstruction.setLocationId(locationId);
        obstruction.setLocationName(locationName);
        obstruction.setSpecificLocation(specificLocation);
        obstruction.setDescription(description);
        obstruction.setResolved(false);
        obstructionRepository.save(obstruction);

        //log a report for the obstruction
        logReport(idNumber, obstruction.getId(), locationName, specificLocation, reportType, description);
    }
    
    //method to make a report from the obstruction 
    private void logReport(Double idNumber, Long obstructionId, String locationName, String specificLocation, String reportType, String description) {
        User user = userRepository.findByIdNumber(idNumber);

        // Create and save a new report
        Report report = new Report();
        report.setUserId(user.getId());
        report.setUsername(user.getUsername());
        report.setLocationId(obstructionId); // Link to the obstruction
        report.setLocationName(locationName);
        report.setSpecificLocation(specificLocation); // Use the specific location from the reportObstruction input
        report.setDescription(description);
        report.setReportType(reportType);
        reportRepository.save(report);
    }

    
    public List<Obstruction> getActiveObstructions(String locationName) {
    	 Long locationId = locationComponent.getLocationIdByName(locationName); 
         return obstructionRepository.findByLocationId(locationId);
    }
    
    //TO-DO
    public String resolveObstruction(Long obstructionId, String resolutionComment) {
        return null;
    }
	
}
