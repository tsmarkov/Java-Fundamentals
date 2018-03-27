package boat_racing_simulator.models.engines;

import boat_racing_simulator.contracts.BoatEngine;
import boat_racing_simulator.utility.Constants;
import boat_racing_simulator.utility.Validator;

public abstract class BaseBoatEngine implements BoatEngine {
    private String model;
    private int cachedOutput;

    protected BaseBoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
        this.cachedOutput = this.calculateCachedOutput(horsepower, displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getCachedOutput() {
        return this.cachedOutput;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    protected abstract int calculateCachedOutput(int horsepower, int displacement);

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
    }

    private void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
    }
}