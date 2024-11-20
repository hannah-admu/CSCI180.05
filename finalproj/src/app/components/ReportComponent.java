package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Report;
import app.entity.User;
import app.repository.ReportRepository;
import app.repository.UserRepository;

@Component
public class ReportComponent {
	
	@Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getReportsByUser(Double idNumber) {
        User user = userRepository.findByIdNumber(idNumber);
        return reportRepository.findByUserId(user.getId());
    }
    
    public List<Report> getReportsByLocationName(String locationName) {
        return reportRepository.findByLocationNameContaining(locationName);
    }

    public List<Report> getReportsByDescription(String description) {
        return reportRepository.findByDescriptionContaining(description);
    }

    
}
