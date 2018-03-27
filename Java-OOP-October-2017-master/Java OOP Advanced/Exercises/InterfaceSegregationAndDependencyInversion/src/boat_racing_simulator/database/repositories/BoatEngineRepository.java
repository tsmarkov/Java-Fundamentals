package boat_racing_simulator.database.repositories;

import boat_racing_simulator.contracts.BoatEngine;
import boat_racing_simulator.contracts.CrudRepository;
import boat_racing_simulator.exeptions.DuplicateModelException;
import boat_racing_simulator.exeptions.NonExistantModelException;
import boat_racing_simulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository implements CrudRepository<BoatEngine> {
    private Map<String, BoatEngine> boatEngines;

    public BoatEngineRepository() {
        this.boatEngines = new LinkedHashMap<>();
    }

    @Override
    public void add(BoatEngine boat) throws DuplicateModelException {
        if (this.boatEngines.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.boatEngines.put(boat.getModel(), boat);
    }

    @Override
    public BoatEngine getByModel(String model) throws NonExistantModelException {
        if (!this.boatEngines.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }

        return this.boatEngines.get(model);
    }

}