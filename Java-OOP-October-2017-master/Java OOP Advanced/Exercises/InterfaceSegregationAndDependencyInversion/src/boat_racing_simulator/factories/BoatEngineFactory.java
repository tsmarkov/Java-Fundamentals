package boat_racing_simulator.factories;

import boat_racing_simulator.contracts.BoatEngine;
import boat_racing_simulator.models.engines.JetEngine;
import boat_racing_simulator.models.engines.SterndriveEngine;

public final class BoatEngineFactory {

    private BoatEngineFactory() {
    }

    public static BoatEngine createJetEngine(String model, int horsepower, int displacement) {
        return new JetEngine(model, horsepower, displacement);
    }

    public static BoatEngine createSterndriveEngine(String model, int horsepower, int displacement) {
        return new SterndriveEngine(model, horsepower, displacement);
    }
}
