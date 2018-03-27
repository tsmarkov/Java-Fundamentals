package bg.softuni.models;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseEmergencyCenter {
    private String name;
    private Integer amountOfMaximumEmergencies;
    private int processedEmergenciesCount;
    // /private List<BaseEmergency> processedEmergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.processedEmergenciesCount = 0;
        //this.processedEmergencies = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void incrementProcessedEmergenciesCount() {
        this.processedEmergenciesCount++;
    }

    public int getProcessedEmergenciesCount() {
        return this.processedEmergenciesCount;
    }

    //public List<BaseEmergency> getProcessedEmergencies() {
    //    return processedEmergencies;
    //}

    //private void setProcessedEmergencies(List<BaseEmergency> processedEmergencies) {
    //    this.processedEmergencies = processedEmergencies;
    //}

    //public void addProcessedEmergency(BaseEmergency emergency) {
    //    this.processedEmergencies.add(emergency);
    //}

    public Integer getAmountOfMaximumEmergencies() {
        return this.amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    public Boolean isForRetirement() {
        return this.getProcessedEmergenciesCount() >= this.getAmountOfMaximumEmergencies();
    }
}
