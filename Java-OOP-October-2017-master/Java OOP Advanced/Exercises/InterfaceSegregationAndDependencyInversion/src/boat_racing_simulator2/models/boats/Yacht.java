package boat_racing_simulator2.models.boats;

import boat_racing_simulator2.contracts.BoatRace;
import boat_racing_simulator2.models.boat_engines.BaseBoatEngine;
import boat_racing_simulator2.utility.Validator;

public class Yacht extends BaseMotorBoat {

    private int cargo;

    public Yacht(String model, int weight, BaseBoatEngine engine, int cargo) {
        super(model, weight, engine);
        this.setCargo(cargo);
    }

    @Override
    public double calculateRaceSpeed(BoatRace boatRace) {
        return super.getEngine().getOutput() - super.getWeight() - this.cargo + boatRace.getOceanCurrentSpeed() / 2D;
    }

    private void setCargo(int cargo) {
        Validator.validatePropertyPositiveValue(cargo, "Cargo Weight");
        this.cargo = cargo;
    }

}
