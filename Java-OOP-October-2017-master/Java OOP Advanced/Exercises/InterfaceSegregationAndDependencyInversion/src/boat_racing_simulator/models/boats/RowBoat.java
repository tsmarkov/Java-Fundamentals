package boat_racing_simulator.models.boats;

import boat_racing_simulator.contracts.Race;
import boat_racing_simulator.utility.Validator;

public final class RowBoat extends BaseBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    @Override
    public boolean hasEngineInBoat() {
        return false;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.oars * 100.0) - super.getWeight() + race.getOceanCurrentSpeed();
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }
}