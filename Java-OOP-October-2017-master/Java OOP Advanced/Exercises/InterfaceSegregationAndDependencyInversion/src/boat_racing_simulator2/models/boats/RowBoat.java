package boat_racing_simulator2.models.boats;

import boat_racing_simulator2.contracts.BoatRace;
import boat_racing_simulator2.models.boats.BaseBoat;
import boat_racing_simulator2.utility.Validator;

public class RowBoat extends BaseBoat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    @Override
    public double calculateRaceSpeed(BoatRace boatRace) {
        return this.oars * 100D - super.getWeight() + boatRace.getOceanCurrentSpeed();
    }

    private void setOars(int oars) {
        Validator.validatePropertyPositiveValue(oars, "Oars");
        this.oars = oars;
    }

}
