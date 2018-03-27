package bg.softuni.models;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public abstract class BaseEmergency {
    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTime registrationTime;
    private Boolean isProcessed;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
        this.isProcessed = true;
    }


    public String getDescription() {
        return this.description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public EmergencyLevel getEmergencyLevel() {
        return this.emergencyLevel;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public RegistrationTime getRegistrationTime() {
        return this.registrationTime;
    }

    private void setRegistrationTime(RegistrationTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public boolean isProcessed() {
        return this.isProcessed;
    }

    public void process() {
        this.isProcessed = true;
    }
}
