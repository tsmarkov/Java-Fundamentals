package boat_racing_simulator.factories;

import boat_racing_simulator.contracts.Race;
import boat_racing_simulator.models.RaceImpl;

public final class RaceFactory {

    private RaceFactory() {
    }

    public static Race createRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        return new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorBoats);
    }
}
