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
    
    //TO-DO
    public void createUser(String username, Double phoneNumber, Double idNumber) {
    
    }
    
    //TO-DO
    public void updatePhoneNumber(Double idNumber, String phoneNumber) {
        
    }
    
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
    
    //deletes user 
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User not found with ID: " + userId);
        }
        userRepository.deleteById(userId);
    }

}
