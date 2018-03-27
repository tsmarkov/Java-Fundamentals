package boat_racing_simulator.models.boats;

import boat_racing_simulator.contracts.Boat;
import boat_racing_simulator.utility.Constants;
import boat_racing_simulator.utility.Validator;

public abstract class BaseBoat implements Boat {
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    protected int getWeight() {
        return this.weight;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}