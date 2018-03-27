package boat_racing_simulator2.models.boat_engines;

import boat_racing_simulator2.contracts.Modelable;
import boat_racing_simulator2.utility.Constants;
import boat_racing_simulator2.utility.Validator;

public abstract class BaseBoatEngine implements Modelable {

    private String model;
    private int horsepower;
    private int displacement;
    public int output;

    public BaseBoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public int getOutput() {
        return this.horsepower * this.getMultiplier() + this.displacement;
    }

    protected abstract int getMultiplier();

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyPositiveValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyPositiveValue(displacement, "Displacement");
        this.displacement = displacement;
    }

}
