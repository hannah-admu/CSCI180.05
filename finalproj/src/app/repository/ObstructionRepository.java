package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Obstruction;

@Repository 
public interface ObstructionRepository extends JpaRepository<Obstruction, Long>{
	
	Obstruction findByid(Long id);
    List<Obstruction> findByLocationNameContaining(String locationName);
    List<Obstruction> findByDescriptionContaining(String description); 
    List<Obstruction> findByLocationId(Long locationId);

}
