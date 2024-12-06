package app.components;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.User;
import app.repository.UserRepository;

@Component
public class UserComponent {
	
	@Autowired
    private UserRepository userRepository;
    
    //WORKS - makes a user with only username, phonenumber and idNumber. userId is auto incremented, admin is auto set to false, and 
	//		- user will need to set the location notifs themselves
    public void createUser(String username, String phoneNumber, Double idNumber) {
    
        if (userRepository.findByIdNumber(idNumber) != null) {
            throw new IllegalArgumentException("User with ID number " + idNumber + " already exists."); //because in ateneo, ID numbers are never repeated
        }
        User user = new User();
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);
        user.setIdNumber(idNumber);
        userRepository.save(user); 
    	
    }
    
    //WORKS - updates a user's phone number based on their idNumber
    public void updatePhoneNumber(Double idNumber, String phoneNumber) {
        User user = userRepository.findByIdNumber(idNumber);
        if (user == null) {
            throw new EntityNotFoundException("User not found with ID number: " + idNumber);
        }
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }
    
    //WORKS - sets a user's notif preferences based on their idNumber. Eats a JSON that has a list of location Ids that the user wants to set
    //		- then, this method turns that list into a string to store in the db, because I could NOT for the life of me figure out how to properly store lists in the db
    public void setNotificationPreferences(Double idNumber, List<Long> locationIds) {
        User user = userRepository.findByIdNumber(idNumber);
        if (user == null) {
            throw new EntityNotFoundException("User not found with ID: " + idNumber);
        }

        //convert the list to a string with comma
        String notifications = locationIds.stream() //convert to stream, its a seq of elements that u can map filter etc 
                                          .map(String::valueOf) //turn the long elements into a string
                                          .collect(Collectors.joining(","));
        user.setLocationNotifications(notifications);
        userRepository.save(user);
    }
    
    //WORKS - basically the reverse of setNotificationPreferences. returns a JSON with a List of locationIds that the user wants notifs to
    public List<Long> getNotificationPreferences(Double idNumber) {
        User user = userRepository.findByIdNumber(idNumber);
        if (user == null) {
            throw new EntityNotFoundException("User not found with ID: " + idNumber);
        }

        //parse comma-separated string into a list of Longs
        String notifications = user.getLocationNotifications();
        if (notifications == null || notifications.isEmpty()) {
            return List.of(); //return an empty list if no notifications are set
        }

        return Arrays.stream(notifications.split(","))
                     .map(Long::valueOf)
                     .toList();
    }
    
    //WORKS - deletes a user based on their idNumber
    public void deleteUser(Double idNumber) {
    		User user = userRepository.findByIdNumber(idNumber);
    	    if (user == null) {
    	        throw new EntityNotFoundException("User not found with ID number: " + idNumber);
    	    }
    	    userRepository.delete(user);
    }

}
