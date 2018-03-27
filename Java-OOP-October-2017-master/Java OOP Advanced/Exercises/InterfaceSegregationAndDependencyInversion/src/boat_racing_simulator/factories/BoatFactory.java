package boat_racing_simulator.factories;

import boat_racing_simulator.contracts.Boat;
import boat_racing_simulator.contracts.BoatEngine;
import boat_racing_simulator.models.boats.PowerBoat;
import boat_racing_simulator.models.boats.RowBoat;
import boat_racing_simulator.models.boats.SailBoat;
import boat_racing_simulator.models.boats.Yacht;

public final class BoatFactory {

    private BoatFactory() {
    }

    public static Boat createRowBoat(String model, int weight, int oar) {
        return new RowBoat(model, weight, oar);
    }

    public static Boat createSailBoat(String model, int weight, int sailEfficiency) {
        return new SailBoat(model, weight, sailEfficiency);
    }

    public static Boat createPowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        return new PowerBoat(model, weight, firstEngine, secondEngine);
    }

    public static Boat createYacht(String model, int weight, BoatEngine engine, int cargoWeight) {
        return new Yacht(model, weight, engine, cargoWeight);
    }
}
