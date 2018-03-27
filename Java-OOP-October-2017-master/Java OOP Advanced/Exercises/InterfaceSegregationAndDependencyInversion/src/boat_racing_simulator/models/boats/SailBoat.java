package boat_racing_simulator.models.boats;

import boat_racing_simulator.contracts.Race;
import boat_racing_simulator.utility.Constants;

public class SailBoat extends BaseBoat {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    @Override
    public boolean hasEngineInBoat() {
        return false;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (race.getWindSpeed() * (this.sailEfficiency / 100.0)) - super.getWeight() + (race.getOceanCurrentSpeed() / 2.0) ;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }
}
