package bg.softuni.models.emergencyCenter;

import bg.softuni.models.BaseEmergencyCenter;

public class MedicalServiceCenter extends BaseEmergencyCenter {
    public MedicalServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
    }

    @Override
    public Boolean isForRetirement() {
        return super.getProcessedEmergenciesCount() >= super.getAmountOfMaximumEmergencies();
    }
}
