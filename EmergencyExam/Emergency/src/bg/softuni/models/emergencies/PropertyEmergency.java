package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.BaseEmergency;
import bg.softuni.utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {
    private int damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }
}
