package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.repository.UserRepository;

@Component
public class UserComponent {
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationComponent locationComponent;
    
    //TO-DO
    public void createUser(String username, Double phoneNumber, Double idNumber) {
    
    }
    
    //TO-DO
    public void updatePhoneNumber(Double idNumber, String phoneNumber) {
        
    }
    
    //TO-DO
    public void setNotificationPreferences(Double idNumber, List<String> locationNames) {
        
    }
    
    //TO-DO
    public List<Long> getNotificationPreferences(Double idNumber) {
		return null;
    }

}
