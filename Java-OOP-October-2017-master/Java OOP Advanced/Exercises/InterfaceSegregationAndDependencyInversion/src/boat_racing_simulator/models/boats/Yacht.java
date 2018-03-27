package boat_racing_simulator.models.boats;

import boat_racing_simulator.contracts.BoatEngine;
import boat_racing_simulator.contracts.Race;
import boat_racing_simulator.utility.Validator;

public class Yacht extends BaseBoat {

    private BoatEngine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine boatEngine, int cargoWeight) {
        super(model, weight);
        this.boatEngine = boatEngine;
        this.setCargoWeight(cargoWeight);
    }

    @Override
    public boolean hasEngineInBoat() {
        return true;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.boatEngine.getCachedOutput() - (super.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed() / 2.0);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }
}
