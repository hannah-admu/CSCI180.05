package app.components;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.TwilioReplyDTO;
import app.entity.Location;
import app.entity.Obstruction;
import app.entity.User;
import app.repository.LocationRepository;
import app.repository.ObstructionRepository;
import app.repository.UserRepository;

@Component
public class NotificationComponent {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	ObstructionRepository obstRepo;
	@Autowired
	LocationRepository locaRepo;
	@Autowired
	TwilioComponent twilioComponent;
		
	
	public User getUser(Long id) {
		return userRepo.findByid(id);
	}
	
	public Obstruction getObstruction(Long id) {
		return obstRepo.findByid(id);
	}
	
	public String getLocationNameByObstructionID(Long obstID) {
		Obstruction obst = getObstruction(obstID);
		Location location = locaRepo.findByid(obst.getLocationId());
		return location.getName();
	}
	
	public Boolean isInLocationNotifs(User user, String location) {
		return user.getLocationNotifications().contains(location);
	}

	public TwilioReplyDTO notify(Long userID, Long obstID) throws IOException {
		
		User user = getUser(userID);
		if (user == null) {
	        System.out.println("Please input a valid user");
	        return null;
	    }
		
		Obstruction obst = getObstruction(obstID);
		if (obst == null) {
	        System.out.println("Please input a valid obstruction");
	        return null;
	    }
		
		String message = 
				"There has been an obstruction in a location you have chosen to receive notifications about.\r\n"
				+ "\r\n"
				+ "Where: [location.name, obstruction.specificLocation]\r\n"
				+ "Description of obstruction: [obstruction.description]\r\n"
				+ "\r\n"
				+ "Kindly be careful around this area in the immediate future while the obstruction is taken care of. Stay safe!";
		
		TwilioReplyDTO twilioReply = twilioComponent.sendMessage(user.getPhoneNumber(), message);
		System.out.println(twilioReply);
		return twilioReply;
	}
	
	public int notifyByObstacleLocation(Long obstID) throws IOException {
		
		String locationName = getLocationNameByObstructionID(obstID); 
		
		List<User> users = userRepo.findAll();
		int sent = 0;
		
		for (User user: users) {
			if (isInLocationNotifs(user, locationName)) {
				notify(user.getId(), obstID);
				sent++;
			}
		}
		
		return sent;
	}
}
