package boat_racing_simulator2.models.boats;

import boat_racing_simulator2.contracts.BoatRace;
import boat_racing_simulator2.contracts.Modelable;
import boat_racing_simulator2.utility.Constants;
import boat_racing_simulator2.utility.Validator;

public abstract class BaseBoat implements Modelable {

    private String model;
    private int weight;

    public BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    public final int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyPositiveValue(weight, "Weight");
        this.weight = weight;
    }

    public boolean hasEngine() {
        return false;
    }

    public abstract double calculateRaceSpeed(BoatRace boatRace);

}
