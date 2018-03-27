package boat_racing_simulator2.models.boats;

import boat_racing_simulator2.models.boat_engines.BaseBoatEngine;

public abstract class BaseMotorBoat extends BaseBoat {

    private BaseBoatEngine engine;

    public BaseMotorBoat(String model, int weight, BaseBoatEngine engine) {
        super(model, weight);
        this.engine = engine;
    }

    @Override
    public boolean hasEngine() {
        return true;
    }

    protected BaseBoatEngine getEngine() {
        return this.engine;
    }
    
}
