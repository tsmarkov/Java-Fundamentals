package boat_racing_simulator.database;

import boat_racing_simulator.contracts.Boat;
import boat_racing_simulator.contracts.BoatEngine;
import boat_racing_simulator.contracts.CrudRepository;
import boat_racing_simulator.contracts.Database;

public class DatabaseImpl implements Database {
    private CrudRepository<Boat> boatRepository;
    private CrudRepository<BoatEngine> boatEngineRepository;

    public DatabaseImpl(CrudRepository<Boat> boatRepository, CrudRepository<BoatEngine> boatEngineRepository) {
        this.boatRepository = boatRepository;
        this.boatEngineRepository = boatEngineRepository;
    }

    @Override
    public CrudRepository<Boat> getBoatRepository() {
        return this.boatRepository;
    }

    @Override
    public CrudRepository<BoatEngine> getBoatEngineRepository() {
        return this.boatEngineRepository;
    }
}
