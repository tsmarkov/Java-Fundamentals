package bg.softuni.core;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.BaseEmergency;
import bg.softuni.models.BaseEmergencyCenter;
import bg.softuni.models.emergencies.HealthEmergency;
import bg.softuni.models.emergencies.OrderEmergency;
import bg.softuni.models.emergencies.PropertyEmergency;
import bg.softuni.models.emergencyCenter.FiremanServiceCenter;
import bg.softuni.models.emergencyCenter.MedicalServiceCenter;
import bg.softuni.models.emergencyCenter.PoliceServiceCenter;
import bg.softuni.utils.RegistrationTime;

import java.util.*;

public class EmergencyManagementSystem {
    private static final String PROPERTY_EMERGENCY = "Property";
    private static final String HEALTH_EMERGENCY = "Health";
    private static final String ORDER_EMERGENCY = "Order";

    private Map<String, EmergencyRegister> emergencies;
    private Map<String, ArrayDeque<BaseEmergencyCenter>> centers;

    public EmergencyManagementSystem() {
        this.setEmergenciesMap();
        this.setEmergencyCentersMap();
    }

    private void setEmergenciesMap() {
        this.emergencies = new LinkedHashMap<>();
        this.emergencies.put(PROPERTY_EMERGENCY, new EmergencyRegister());
        this.emergencies.put(HEALTH_EMERGENCY, new EmergencyRegister());
        this.emergencies.put(ORDER_EMERGENCY, new EmergencyRegister());
    }

    private void setEmergencyCentersMap() {
        this.centers = new LinkedHashMap<>();
        this.centers.put(PROPERTY_EMERGENCY, new ArrayDeque<>());
        this.centers.put(HEALTH_EMERGENCY, new ArrayDeque<>());
        this.centers.put(ORDER_EMERGENCY, new ArrayDeque<>());
    }

    public String registerPropertyEmergency(String[] args) {
        String description = args[1];
        EmergencyLevel level = EmergencyLevel.valueOf(args[2]);
        RegistrationTime registrationTime = new RegistrationTime(args[3]);
        Integer propertyDamage = Integer.valueOf(args[4]);

        BaseEmergency emergency = new PropertyEmergency(description, level, registrationTime, propertyDamage);

        this.emergencies.get(PROPERTY_EMERGENCY).enqueueEmergency(emergency);

        return String.format("Registered Public Property Emergency of level %s at %s.", args[2], args[3]);
    }

    public String registerHealthEmergency(String[] args) {
        String description = args[1];
        EmergencyLevel level = EmergencyLevel.valueOf(args[2]);
        RegistrationTime registrationTime = new RegistrationTime(args[3]);
        Integer casualties = Integer.valueOf(args[4]);

        BaseEmergency emergency = new HealthEmergency(description, level, registrationTime, casualties);

        this.emergencies.get(HEALTH_EMERGENCY).enqueueEmergency(emergency);

        return String.format("Registered Public Health Emergency of level %s at %s.", args[2], args[3]);
    }

    public String registerOrderEmergency(String[] args) {
        String description = args[1];
        EmergencyLevel level = EmergencyLevel.valueOf(args[2]);
        RegistrationTime registrationTime = new RegistrationTime(args[3]);
        String status = args[4];

        BaseEmergency emergency = new OrderEmergency(description, level, registrationTime, status);

        this.emergencies.get(ORDER_EMERGENCY).enqueueEmergency(emergency);

        return String.format("Registered Public Order Emergency of level %s at %s.", args[2], args[3]);
    }

    public String registerFireServiceCenter(String[] args) {
        String name = args[1];
        Integer amountOfEmergencies = Integer.valueOf(args[2]);

        BaseEmergencyCenter center = new FiremanServiceCenter(name, amountOfEmergencies);
        this.centers.get(PROPERTY_EMERGENCY).add(center);

        return String.format("Registered Fire Service Emergency Center – %s.", name);
    }

    public String registerMedicalServiceCenter(String[] args) {
        String name = args[1];
        Integer amountOfEmergencies = Integer.valueOf(args[2]);

        BaseEmergencyCenter center = new MedicalServiceCenter(name, amountOfEmergencies);
        this.centers.get(HEALTH_EMERGENCY).add(center);

        return String.format("Registered Medical Service Emergency Center – %s.", name);
    }

    public String registerPoliceServiceCenter(String[] args) {
        String name = args[1];
        Integer amountOfEmergencies = Integer.valueOf(args[2]);

        BaseEmergencyCenter center = new PoliceServiceCenter(name, amountOfEmergencies);
        this.centers.get(ORDER_EMERGENCY).add(center);


        return String.format("Registered Police Service Emergency Center - %s.", name);
    }

    public String processEmergencies(String[] args) {
        String type = args[1];

        EmergencyRegister emergencyRegister = this.emergencies.get(type);


        int counter = 0;
        while (this.centers.get(type).size() > 0) {
            BaseEmergencyCenter center = this.centers.get(type).poll();
            BaseEmergency emergency = emergencyRegister.peekEmergency();

            if (emergency.isProcessed()) {
                emergencyRegister.enqueueEmergency(emergencyRegister.dequeueEmergency());
                break;
            }

            if (!center.isForRetirement()) {
                emergencyRegister.peekEmergency().process();
                emergencyRegister.enqueueEmergency(emergencyRegister.dequeueEmergency());

                center.incrementProcessedEmergenciesCount();
            }


            if (center.isForRetirement()) {
                this.centers.get(type).pollFirst();
                this.centers.get(type).addLast(center);
            }
        }

        //if (this.centers)

        return null;
    }

    public String emergencyReport() {
        return null;
    }
}
