package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
	
	Location findByid(Long id);
	Location findByName (String name);
    List<Location> findByHasRamp(Boolean hasRamp);
    List<Location> findByHasElevator(Boolean hasElevator);
    
}
