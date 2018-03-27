package boat_racing_simulator.contracts;

import boat_racing_simulator.exeptions.DuplicateModelException;
import boat_racing_simulator.exeptions.NonExistantModelException;

public interface CrudRepository<T> {

    void add(T item) throws DuplicateModelException;

    T getByModel(String model) throws NonExistantModelException;
}
