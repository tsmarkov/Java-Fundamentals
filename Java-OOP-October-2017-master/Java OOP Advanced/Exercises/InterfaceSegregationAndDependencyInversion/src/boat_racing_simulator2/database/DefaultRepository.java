package boat_racing_simulator2.database;

import boat_racing_simulator2.contracts.Modelable;
import boat_racing_simulator2.contracts.Repository;
import boat_racing_simulator2.exceptions.DuplicateModelException;
import boat_racing_simulator2.exceptions.NonExistantModelException;
import boat_racing_simulator2.utility.Constants;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultRepository<T extends Modelable> implements Repository<T> {

    private Map<String, T> itemsByModel;

    public DefaultRepository() {
        this.itemsByModel = new LinkedHashMap<>();
    }

    @Override
    public void add(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public T getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }
        return this.itemsByModel.get(model);
    }

}
