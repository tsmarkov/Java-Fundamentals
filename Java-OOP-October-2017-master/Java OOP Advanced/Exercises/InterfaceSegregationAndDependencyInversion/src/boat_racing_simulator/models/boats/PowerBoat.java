package boat_racing_simulator.models.boats;

import boat_racing_simulator.contracts.BoatEngine;
import boat_racing_simulator.contracts.Race;

public class PowerBoat extends BaseBoat {

    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    @Override
    public boolean hasEngineInBoat() {
        return true;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.firstEngine.getCachedOutput() + this.secondEngine.getCachedOutput()) - super.getWeight() + (race.getOceanCurrentSpeed() / 5.0);
    }
}
