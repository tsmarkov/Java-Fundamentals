package boat_racing_simulator2.database;

import boat_racing_simulator2.contracts.Repository;
import boat_racing_simulator2.models.boats.BaseBoat;
import boat_racing_simulator2.models.boat_engines.BaseBoatEngine;

public class BoatSimulatorDatabase {

    Repository<BaseBoat> boats;
    Repository<BaseBoatEngine> engines;

    public BoatSimulatorDatabase() {
        this.boats = new DefaultRepository<>();
        this.engines = new DefaultRepository<>();
    }

    public Repository<BaseBoat> getBoats() {
        return this.boats;
    }

    public Repository<BaseBoatEngine> getEngines() {
        return this.engines;
    }

}
