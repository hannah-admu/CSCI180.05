package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	
	List<Report> findByLocationNameContaining(String locationName);
	List<Report> findByDescriptionContaining(String description);
	List<Report> findByUserId(Long userId);
}
