package boat_racing_simulator2.contracts;

import boat_racing_simulator2.exceptions.DuplicateModelException;
import boat_racing_simulator2.exceptions.NonExistantModelException;

public interface Repository<T extends Modelable> {
    
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
    
}
