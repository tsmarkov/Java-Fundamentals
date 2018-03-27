package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.BaseEmergency;
import bg.softuni.utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {
    private String status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }
}
