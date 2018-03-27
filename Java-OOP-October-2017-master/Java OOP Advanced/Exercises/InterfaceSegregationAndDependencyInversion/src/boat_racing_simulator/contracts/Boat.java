package boat_racing_simulator.contracts;

public interface Boat extends Modelable {

    boolean hasEngineInBoat();

    double calculateRaceSpeed(Race race);
}
