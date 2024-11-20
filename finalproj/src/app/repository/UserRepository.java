package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//this isnt in our specs i just thought itd be useful to have 
    User findByIdNumber(Double idNumber);
    List<User> findByUsername(String username);
    
    //get the list of location ids a user wants notifs for 
    @Query("SELECT u.locationNotifications FROM User u WHERE u.idNumber = :idNumber") //had to make my own query isnt that cool 
    List<Long> findLocationNotificationsByIdNumber(@Param("idNumber") Double idNumber);

}
