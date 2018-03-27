package boat_racing_simulator.database.repositories;

import boat_racing_simulator.contracts.Boat;
import boat_racing_simulator.contracts.CrudRepository;
import boat_racing_simulator.exeptions.DuplicateModelException;
import boat_racing_simulator.exeptions.NonExistantModelException;
import boat_racing_simulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository implements CrudRepository<Boat> {
    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new LinkedHashMap<>();
    }

    @Override
    public void add(Boat boat) throws DuplicateModelException {
        if (this.boats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.boats.put(boat.getModel(), boat);
    }

    @Override
    public Boat getByModel(String model) throws NonExistantModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }

        return this.boats.get(model);
    }

}