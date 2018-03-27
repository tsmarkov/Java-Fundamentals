package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.BaseEmergency;
import bg.softuni.utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency {
    private int casualtiesNumber;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int casualtiesNumber) {
        super(description, emergencyLevel, registrationTime);
        this.casualtiesNumber = casualtiesNumber;
    }
}
