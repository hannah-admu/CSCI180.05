package app.dto;

import java.util.List;

public class UserNotificationPreferencesDTO {
    private Double idNumber;
    private List<Long> locationIds;

    public Double getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Double idNumber) {
        this.idNumber = idNumber;
    }

    public List<Long> getLocationIds() {
        return locationIds;
    }

    public void setLocationIds(List<Long> locationIds) {
        this.locationIds = locationIds;
    }
}
